/**************************************************************************************************
 * project
 * Description - Sys0206 - Organisation Management
 *	- Generated by Source Generator
 *************************************************************************************************/
package project.app.sys.sys0206;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import project.common.extend.BaseBiz;
import project.common.module.datahelper.DataHelper;
import project.conf.resource.ormapper.dao.SysOrg.SysOrgDao;
import project.conf.resource.ormapper.dto.oracle.SysOrg;
import zebra.config.MemoryBean;
import zebra.data.DataSet;
import zebra.data.ParamEntity;
import zebra.data.QueryAdvisor;
import zebra.exception.FrameworkException;
import zebra.export.ExportHelper;
import zebra.util.CommonUtil;
import zebra.util.ConfigUtil;
import zebra.util.ExportUtil;
import zebra.util.FileUtil;

public class Sys0206BizImpl extends BaseBiz implements Sys0206Biz {
	@Autowired
	private SysOrgDao sysOrgDao;

	public ParamEntity getDefault(ParamEntity paramEntity) throws Exception {
		try {
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getList(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		HttpSession session = paramEntity.getSession();

		try {
			queryAdvisor.setObject("langCode", (String)session.getAttribute("langCode"));
			queryAdvisor.setRequestDataSet(requestDataSet);
			queryAdvisor.setPagination(true);

			paramEntity.setAjaxResponseDataSet(sysOrgDao.getOrgDataSetByCriteria(queryAdvisor));
			paramEntity.setTotalResultRows(queryAdvisor.getTotalResultRows());
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getEdit(ParamEntity paramEntity) throws Exception {
		String defaultLogoPath = ConfigUtil.getProperty("path.image.orgLogo")+"/"+"DefaultLogo.png";

		try {
			paramEntity.setObject("defaultLogoPath", defaultLogoPath);
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity getOrgDetail(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		String orgId = requestDataSet.getValue("orgId");
		DataSet orgDataSet = new DataSet();

		try {
			orgDataSet = sysOrgDao.getDataSetByOrgId(orgId);
			orgDataSet.addColumn("INSERT_USER_NAME", DataHelper.getUserNameById(orgDataSet.getValue("INSERT_USER_ID")));
			orgDataSet.addColumn("UPDATE_USER_NAME", DataHelper.getUserNameById(orgDataSet.getValue("UPDATE_USER_ID")));

			paramEntity.setAjaxResponseDataSet(orgDataSet);
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity saveOrgDetail(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		DataSet fileDataSet = paramEntity.getRequestFileDataSet();
		HttpSession session = paramEntity.getSession();
		String orgId = "", saveType = "";
		String defaultFileName = "DefaultLogo.png";
		String defaultLogoPath = ConfigUtil.getProperty("path.image.orgLogo");
		String uploadLogoPath = ConfigUtil.getProperty("path.dir.uploadedOrgLogo");
		String webRootPath = (String)MemoryBean.get("applicationRealPath");
		String pathToCopy = "";
		String dateFormat = ConfigUtil.getProperty("format.date.java");
		SysOrg sysOrg = new SysOrg();
		DataSet orgDataSet;
		int result = -1;

		try {
			orgId = requestDataSet.getValue("orgId");

			if (CommonUtil.isBlank(orgId)) {
				saveType = "Insert";
				orgId = CommonUtil.uid();
			}

			if (CommonUtil.equals(saveType, "Insert")) {
				sysOrg.setInsertUserId((String)session.getAttribute("UserId"));
				sysOrg.setInsertDate(CommonUtil.toDate(CommonUtil.getSysdate()));

				if (fileDataSet.getRowCnt() <= 0) {
					sysOrg.setLogoPath(defaultLogoPath + "/" + defaultFileName);
				}
			} else {
				sysOrg.setUpdateUserId((String)session.getAttribute("UserId"));
				sysOrg.setUpdateDate(CommonUtil.toDate(CommonUtil.getSysdate()));
			}


			sysOrg.setOrgId(orgId);
			sysOrg.setLegalName(CommonUtil.replace(requestDataSet.getValue("legalName"), "||", "&"));
			sysOrg.setTradingName(CommonUtil.replace(requestDataSet.getValue("tradingName"), "||", "&"));
			sysOrg.setAbn(CommonUtil.remove(requestDataSet.getValue("abn"), " "));
			sysOrg.setAcn(CommonUtil.remove(requestDataSet.getValue("acn"), " "));
			sysOrg.setTelNumber(CommonUtil.remove(requestDataSet.getValue("telNumber"), " "));
			sysOrg.setMobileNumber(CommonUtil.remove(requestDataSet.getValue("mobileNumber"), " "));
			sysOrg.setEmail(requestDataSet.getValue("email"));
			sysOrg.setAddress(requestDataSet.getValue("address"));
			sysOrg.setRegisteredDate(CommonUtil.toDate(requestDataSet.getValue("registeredDate"), dateFormat));
			sysOrg.setIsActive(requestDataSet.getValue("isActive"));
			sysOrg.setEntityType(requestDataSet.getValue("entityType"));
			sysOrg.setBusinessType(requestDataSet.getValue("businessType"));
			sysOrg.setBaseType(requestDataSet.getValue("baseType"));
			sysOrg.setRevenueRangeFrom(CommonUtil.toDouble(requestDataSet.getValue("rRangeFrom")));
			sysOrg.setRevenueRangeTo(CommonUtil.toDouble(requestDataSet.getValue("rRangeTo")));

			if (fileDataSet.getRowCnt() > 0) {
				String fileName = fileDataSet.getValue("NEW_NAME");
				String orgFileName = orgId + "_" + fileName;

				// Copy the file to web source
				pathToCopy = webRootPath + defaultLogoPath + "/" + orgFileName;
				FileUtil.copyFile(fileDataSet, pathToCopy);

				// Move the file to repository
				pathToCopy = uploadLogoPath + "/" + orgFileName;
				FileUtil.moveFile(fileDataSet, pathToCopy);

				sysOrg.setLogoPath(defaultLogoPath + "/" + orgFileName);
			}

			if (CommonUtil.equals(saveType, "Insert")) {
				result = sysOrgDao.insert(sysOrg);
			} else {
				sysOrg.addUpdateColumnFromField();
				result = sysOrgDao.update(orgId, sysOrg);
			}

			if (result <= 0) {
				throw new FrameworkException("E801", getMessage("E801", paramEntity));
			}

			orgDataSet = sysOrgDao.getDataSetByOrgId(orgId);
			orgDataSet.addColumn("INSERT_USER_NAME", DataHelper.getUserNameById(orgDataSet.getValue("INSERT_USER_ID")));
			orgDataSet.addColumn("UPDATE_USER_NAME", DataHelper.getUserNameById(orgDataSet.getValue("UPDATE_USER_ID")));

			paramEntity.setAjaxResponseDataSet(orgDataSet);
			paramEntity.setSuccess(true);
			paramEntity.setMessage("I801", getMessage("I801", paramEntity));
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity exeDelete(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		String orgId = requestDataSet.getValue("orgId");
		String chkForDel = requestDataSet.getValue("chkForDel");
		String orgIds[] = CommonUtil.splitWithTrim(chkForDel, ConfigUtil.getProperty("delimiter.record"));
		int result = 0;

		try {
			if (CommonUtil.isBlank(orgId)) {
				result = sysOrgDao.delete(orgIds);
			} else {
				result = sysOrgDao.delete(orgId);
			}

			if (result <= 0) {
				throw new FrameworkException("E801", getMessage("E801", paramEntity));
			}

			paramEntity.setSuccess(true);
			paramEntity.setMessage("I801", getMessage("I801", paramEntity));
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity exeExport(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		ExportHelper exportHelper;
		String columnHeader[], fileHeader[];
		String pageTitle, fileName;
		String fileType = requestDataSet.getValue("fileType");
		String dataRange = requestDataSet.getValue("dataRange");
		HttpSession session = paramEntity.getSession();

		try {
			pageTitle = "Organisation List";
			fileName = "OrganisationList";
			columnHeader = new String[]{"legal_name", "trading_name", "abn", "user_cnt", "entity_type_name", "business_type_name", "org_category_name", "wage_type_name",
					"revenue_range_from", "revenue_range_to", "registered_date"};
			fileHeader = new String[]{"Leagal Name", "Trading Name", "ABN", "Users", "Entity Type", "Business Type", "Org Category", "Wage Type",
					"R Range From", "R Range To", "Registered Date"};

			exportHelper = ExportUtil.getExportHelper(fileType);
			exportHelper.setPageTitle(pageTitle);
			exportHelper.setColumnHeader(columnHeader);
			exportHelper.setFileHeader(fileHeader);
			exportHelper.setFileName(fileName);
			exportHelper.setPdfWidth(1000);

			queryAdvisor.setRequestDataSet(requestDataSet);
			queryAdvisor.setObject("langCode", (String)session.getAttribute("langCode"));
			if (CommonUtil.containsIgnoreCase(dataRange, "all"))
				queryAdvisor.setPagination(false);
			else {
				queryAdvisor.setPagination(true);
			}

			exportHelper.setSourceDataSet(sysOrgDao.getOrgDataSetByCriteria(queryAdvisor));

			paramEntity.setSuccess(true);
			paramEntity.setFileToExport(exportHelper.createFile());
			paramEntity.setFileNameToExport(exportHelper.getFileName());
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}
}