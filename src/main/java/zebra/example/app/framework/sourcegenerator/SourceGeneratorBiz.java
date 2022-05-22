package zebra.example.app.framework.sourcegenerator;

import zebra.data.ParamEntity;

public interface SourceGeneratorBiz {
	public ParamEntity getDefault(ParamEntity paramEntity) throws Exception;
}