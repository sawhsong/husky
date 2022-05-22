package zebra.example.app.framework.sourcegenerator;

import org.springframework.beans.factory.annotation.Autowired;

import zebra.example.common.extend.BaseAction;

public class SourceGeneratorAction extends BaseAction {
	@Autowired
	private SourceGeneratorBiz biz;

	public String getDefault() throws Exception {
		biz.getDefault(paramEntity);
		return "list";
	}
}