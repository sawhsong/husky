/**************************************************************************************************
 * project
 * Description - Bau0204 - Announcement
 *	- Generated by Source Generator
 *************************************************************************************************/
package project.app.bau.bau0204;

import org.springframework.beans.factory.annotation.Autowired;

import project.common.extend.BaseAction;

public class Bau0204Action extends BaseAction {
	@Autowired
	private Bau0204Biz biz;

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

	public String getDetail() throws Exception {
		biz.getDetail(paramEntity);
		return "detail";
	}

	public String getAttachedFile() throws Exception {
		try {
			biz.getAttachedFile(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}
}