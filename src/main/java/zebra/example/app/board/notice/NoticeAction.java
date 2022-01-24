package zebra.example.app.board.notice;

import org.springframework.beans.factory.annotation.Autowired;

import zebra.example.common.extend.BaseAction;

public class NoticeAction extends BaseAction {
	@Autowired
	private NoticeBiz biz;

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

	public String getInsert() throws Exception {
		biz.getInsert(paramEntity);
		return "insert";
	}

	public String getUpdate() throws Exception {
		biz.getUpdate(paramEntity);
		return "update";
	}

	public String getAttachedFile() throws Exception {
		try {
			biz.getAttachedFile(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String exeInsert() throws Exception {
		try {
			biz.exeInsert(paramEntity);
		} catch (Exception ex) {
		}
		setRequestAttribute("paramEntity", paramEntity);
		return "ajaxResponse";
	}

	public String exeUpdate() throws Exception {
		try {
			biz.exeUpdate(paramEntity);
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
		// ExportAction needs paramEntity to be set into request - In ExportAction ParamEntity is different
		setRequestAttribute("paramEntity", paramEntity);
		return "export";
	}
}