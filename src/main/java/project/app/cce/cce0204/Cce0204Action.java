/**************************************************************************************************
 * project
 * Description - Cce0204 - Credit Card Statement Allocation
 *	- Generated by Source Generator
 *************************************************************************************************/
package project.app.cce.cce0204;

import org.springframework.beans.factory.annotation.Autowired;

import project.common.extend.BaseAction;

public class Cce0204Action extends BaseAction {
	@Autowired
	private Cce0204Biz biz;

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

	public String getReconCategoryDataSet() throws Exception {
		try {
			biz.getReconCategoryDataSet(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getSubReconCategory() throws Exception {
		try {
			biz.getSubReconCategory(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String getEdit() throws Exception {
		try {
			biz.getEdit(paramEntity);
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

	public String getBatchApplication() throws Exception {
		biz.getBatchApplication(paramEntity);
		return "batch";
	}

	public String doBatchApplication() throws Exception {
		try {
			biz.doBatchApplication(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}
}