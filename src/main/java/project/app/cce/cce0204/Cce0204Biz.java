/**************************************************************************************************
 * project
 * Description - Cce0204 - Credit Card Statement Allocation
 *	- Generated by Source Generator
 *************************************************************************************************/
package project.app.cce.cce0204;

import zebra.data.ParamEntity;

public interface Cce0204Biz {
	public ParamEntity getDefault(ParamEntity paramEntity) throws Exception;
	public ParamEntity getList(ParamEntity paramEntity) throws Exception;
	public ParamEntity getReconCategoryDataSet(ParamEntity paramEntity) throws Exception;
	public ParamEntity getSubReconCategory(ParamEntity paramEntity) throws Exception;
	public ParamEntity getEdit(ParamEntity paramEntity) throws Exception;

	public ParamEntity doSave(ParamEntity paramEntity) throws Exception;
	public ParamEntity doDelete(ParamEntity paramEntity) throws Exception;
	public ParamEntity getBatchApplication(ParamEntity paramEntity) throws Exception;
	public ParamEntity doBatchApplication(ParamEntity paramEntity) throws Exception;
}