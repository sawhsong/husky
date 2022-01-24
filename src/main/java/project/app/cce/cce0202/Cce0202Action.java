/**************************************************************************************************
 * project
 * Description - Cce0202 - Credit Card Statement Upload
 *	- Generated by Source Generator
 *************************************************************************************************/
package project.app.cce.cce0202;

import org.springframework.beans.factory.annotation.Autowired;

import project.common.extend.BaseAction;

public class Cce0202Action extends BaseAction {
	@Autowired
	private Cce0202Biz biz;

	public String getDefault() throws Exception {
		biz.getDefault(paramEntity);
		return "list";
	}

	public String getList() throws Exception {
		try {
			biz.getList(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getUpload() throws Exception {
		biz.getUpload(paramEntity);
		return "upload";
	}

	public String getBankAccountInfo() throws Exception {
		try {
			biz.getBankAccountInfo(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getFile() throws Exception {
		try {
			biz.getFile(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getDetail() throws Exception {
		biz.getDetail(paramEntity);
		return "detail";
	}

	public String getInfoDataForDetail() throws Exception {
		try {
			biz.getInfoDataForDetail(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getCcStatementDetail() throws Exception {
		try {
			biz.getCcStatementDetail(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String doUpload() throws Exception {
		try {
			biz.doUpload(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String discardCcStatement() throws Exception {
		try {
			biz.discardCcStatement(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String doSave() throws Exception {
		try {
			biz.doSave(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String doDelete() throws Exception {
		try {
			biz.doDelete(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}
}