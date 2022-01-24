/**************************************************************************************************
 * project
 * Description - Sys0804 - Reconciliation Category Mgmt.
 *	- Generated by Source Generator
 *************************************************************************************************/
package project.app.sys.sys0804;

import zebra.data.ParamEntity;

public interface Sys0804Biz {
	public ParamEntity getDefault(ParamEntity paramEntity) throws Exception;
	public ParamEntity getMainCategory(ParamEntity paramEntity) throws Exception;
	public ParamEntity getList(ParamEntity paramEntity) throws Exception;
	public ParamEntity getEdit(ParamEntity paramEntity) throws Exception;
	public ParamEntity getCategory(ParamEntity paramEntity) throws Exception;

	public ParamEntity doSave(ParamEntity paramEntity) throws Exception;
	public ParamEntity doDelete(ParamEntity paramEntity) throws Exception;
}