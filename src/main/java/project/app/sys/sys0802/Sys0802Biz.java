/**************************************************************************************************
 * project
 * Description - Sys0802 - Financial Period Type
 *	- Generated by Source Generator
 *************************************************************************************************/
package project.app.sys.sys0802;

import zebra.data.ParamEntity;

public interface Sys0802Biz {
	public ParamEntity getDefault(ParamEntity paramEntity) throws Exception;
	public ParamEntity getList(ParamEntity paramEntity) throws Exception;
	public ParamEntity getEdit(ParamEntity paramEntity) throws Exception;
	public ParamEntity getFinancialPeriod(ParamEntity paramEntity) throws Exception;

	public ParamEntity doAutoGenerate(ParamEntity paramEntity) throws Exception;
	public ParamEntity doSave(ParamEntity paramEntity) throws Exception;
	public ParamEntity doDelete(ParamEntity paramEntity) throws Exception;
}