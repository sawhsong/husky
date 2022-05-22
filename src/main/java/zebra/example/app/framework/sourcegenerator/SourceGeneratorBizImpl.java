package zebra.example.app.framework.sourcegenerator;

import zebra.data.ParamEntity;
import zebra.example.common.extend.BaseBiz;

public class SourceGeneratorBizImpl extends BaseBiz implements SourceGeneratorBiz {
	public ParamEntity getDefault(ParamEntity paramEntity) throws Exception {
		return paramEntity;
	}
}