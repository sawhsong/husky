package project.common.module.commonlookup;

import zebra.data.ParamEntity;

public interface CommonLookupBiz {
	public ParamEntity getDefault(ParamEntity paramEntity) throws Exception;
	public ParamEntity getCommonCodeForSelectbox(ParamEntity paramEntity) throws Exception;
	public ParamEntity getOrganisationLookup(ParamEntity paramEntity) throws Exception;
	public ParamEntity getQuotationLookup(ParamEntity paramEntity) throws Exception;
	public ParamEntity getBankAccntLookup(ParamEntity paramEntity) throws Exception;
}