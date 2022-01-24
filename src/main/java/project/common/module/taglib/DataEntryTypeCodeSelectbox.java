package project.common.module.taglib;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;

import project.common.module.datahelper.DataHelper;
import zebra.base.TaglibSupport;
import zebra.data.DataSet;
import zebra.util.CommonUtil;

public class DataEntryTypeCodeSelectbox extends TaglibSupport {
	private String codeType;
	private String name;
	private String id;
	private String langCode;
	private String className;
	private String selectedValue;
	private String disabledValue;
	private String status;
	private String script;
	private String style;
	private String isMultiple;
	private String isBootstrap;
	private String checkName = "";
	private String caption;
	private String options;	// for data validator
	private String source;	// common_code source(framework / project)
	private String parentCategoryId;
	private String attribute = "";

	public int doStartTag() {
		try {
			JspWriter jspWriter = pageContext.getOut();
			HttpSession httpSession = pageContext.getSession();
			StringBuffer html = new StringBuffer();
			DataSet ds = new DataSet();
			String classString = "", attrStr = "", attrs[], attr[];

			if (CommonUtil.equalsIgnoreCase(codeType, "FinancialYear")) {
				ds = DataHelper.getDistinctFinancialYearDataSet();
			} else if (CommonUtil.equalsIgnoreCase(codeType, "MainReconCategory")) {
				ds = DataHelper.getMainReconCategoryDataSet();
			} else if (CommonUtil.equalsIgnoreCase(codeType, "SubReconCategory")) {
				ds = DataHelper.getSbuReconCategoryDataSet(parentCategoryId);
			} else if (CommonUtil.equalsIgnoreCase(codeType, "ReconCategoryOptGroup")) {
				ds = DataHelper.getReconCategoryDataSetForOptionGroup();
			}

			langCode = CommonUtil.nvl(langCode, (String)httpSession.getAttribute("langCode"));
			checkName = CommonUtil.containsIgnoreCase(checkName, ".") ? getMessage(checkName, langCode) : checkName;

			if (CommonUtil.isNotBlank(attribute)) {
				attrs = CommonUtil.split(attribute, ";");
				for (int i=0; i<attrs.length; i++) {
					attr = CommonUtil.split(attrs[i], ":");
					attrStr += " "+attr[0]+"=\""+attr[1]+"\"";
				}
			}

			html.append("<select");
			html.append(" id=\"").append(CommonUtil.nvl(id, name)).append("\"");
			html.append(" name=\"").append(name).append("\"");

			if (CommonUtil.isNotEmpty(style)) {html.append(" style=\""+style+"\"");}
			if (CommonUtil.isNotBlank(checkName)) {html.append(" checkName=\""+checkName+"\"");}
			if (CommonUtil.isNotEmpty(options)) {html.append(" "+options);}
			if (CommonUtil.isNotEmpty(script)) {html.append(" onchange=\""+script+"\"");}
			if (CommonUtil.equalsIgnoreCase(isMultiple, "true") || CommonUtil.equalsIgnoreCase(isMultiple, "yes")) {html.append(" multiple=\"multiple\"");}
			if (CommonUtil.equalsIgnoreCase(status, "disabled")) {html.append(" "+status);}
			// css class
			if (CommonUtil.equalsIgnoreCase(isBootstrap, "false") || CommonUtil.equalsIgnoreCase(isBootstrap, "no")) {
				if (CommonUtil.equalsIgnoreCase(isMultiple, "true") || CommonUtil.equalsIgnoreCase(isMultiple, "yes")) {classString = "selMulti";}
				else {classString = "selSingle";}

				if (CommonUtil.equalsIgnoreCase(status, "disabled")) {classString += "Dis";}
				else {classString += "En";}
			} else {
				classString = "bootstrapSelect";
			}

			html.append(" class=\""+classString+" "+className+"\"");
			if (CommonUtil.isNotBlank(attrStr)) {html.append(" "+attrStr+"");}
			html.append(">\n");

			if (CommonUtil.isNotEmpty(caption)) {html.append("<option value=\"\">"+caption+"</option>\n");}

			if (CommonUtil.equalsIgnoreCase(codeType, "FinancialYear")) {
				for (int i=0; i<ds.getRowCnt(); i++) {
					String selected = "", disabledOption = "";

					if (CommonUtil.equals(ds.getValue(i, "PERIOD_YEAR"), selectedValue)) {selected = " selected";}
					if (CommonUtil.containsIgnoreCase(disabledValue, ds.getValue(i, "PERIOD_YEAR"))) {disabledOption = " disabled";}

					html.append("<option value=\""+ds.getValue(i, "PERIOD_YEAR")+"\""+selected+disabledOption+">"+ds.getValue(i, "FINANCIAL_YEAR")+"</option>\n");
				}
			} else if (CommonUtil.isIn(codeType, "MainReconCategory", "SubReconCategory")) {
				for (int i=0; i<ds.getRowCnt(); i++) {
					String selected = "", disabledOption = "";

					if (CommonUtil.equals(ds.getValue(i, "CATEGORY_ID"), selectedValue)) {selected = " selected";}
					if (CommonUtil.containsIgnoreCase(disabledValue, ds.getValue(i, "CATEGORY_ID"))) {disabledOption = " disabled";}

					html.append("<option value=\""+ds.getValue(i, "CATEGORY_ID")+"\""+selected+disabledOption+">"+ds.getValue(i, "CATEGORY_NAME")+"</option>\n");
				}
			} else if (CommonUtil.isIn(codeType, "ReconCategoryOptGroup")) {
				for (int i=0; i<ds.getRowCnt(); i++) {
					String level = ds.getValue(i, "CATEGORY_LEVEL");
					String selected = "", disabledOption = "";

					if (CommonUtil.equals(ds.getValue(i, "CATEGORY_ID"), selectedValue)) {selected = " selected";}
					if (CommonUtil.containsIgnoreCase(disabledValue, ds.getValue(i, "CATEGORY_ID"))) {disabledOption = " disabled";}

					if (CommonUtil.equals(level, "1")) {
						if (i != 0) {
							html.append("</optgroup>\n");
						}
						html.append("<optgroup label=\""+ds.getValue(i, "CATEGORY_NAME")+"\">\n");
					} else {
						html.append("<option value=\""+ds.getValue(i, "CATEGORY_ID")+"\""+selected+disabledOption+">"+ds.getValue(i, "CATEGORY_NAME")+"</option>\n");
					}
				}
			}

			html.append("</select>\n");

			jspWriter.print(html.toString());
		} catch (Exception ex) {
			logger.error(ex);
		}

		return SKIP_BODY;
	}
	/*!
	 * getter / setter
	 */
	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSelectedValue() {
		return selectedValue;
	}

	public void setSelectedValue(String selectedValue) {
		this.selectedValue = selectedValue;
	}

	public String getDisabledValue() {
		return disabledValue;
	}

	public void setDisabledValue(String disabledValue) {
		this.disabledValue = disabledValue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getIsMultiple() {
		return isMultiple;
	}

	public void setIsMultiple(String isMultiple) {
		this.isMultiple = isMultiple;
	}

	public String getIsBootstrap() {
		return isBootstrap;
	}

	public void setIsBootstrap(String isBootstrap) {
		this.isBootstrap = isBootstrap;
	}

	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
}