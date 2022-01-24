/**************************************************************************************************
 * project
 * Description - Sys0206 - Organisation Management
 *	- Generated by Source Generator
 *************************************************************************************************/
package project.app.sys.sys0206;

import org.springframework.beans.factory.annotation.Autowired;

import project.common.extend.BaseAction;

public class Sys0206Action extends BaseAction {
	@Autowired
	private Sys0206Biz biz;

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

	public String getEdit() throws Exception {
		biz.getEdit(paramEntity);
		return "edit";
	}

	public String getOrgDetail() throws Exception {
		try {
			biz.getOrgDetail(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String saveOrgDetail() throws Exception {
		try {
			biz.saveOrgDetail(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String exeDelete() throws Exception {
		try {
			biz.exeDelete(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String exeExport() throws Exception {
		biz.exeExport(paramEntity);
		setRequestAttribute("paramEntity", paramEntity);
		return "export";
	}
}