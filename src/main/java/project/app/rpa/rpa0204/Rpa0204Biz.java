/**************************************************************************************************
 * project
 * Description - Rpa0204 - General Ledger
 *	- Generated by Source Generator
 *************************************************************************************************/
package project.app.rpa.rpa0204;

import zebra.data.ParamEntity;

public interface Rpa0204Biz {
	public ParamEntity getDefault(ParamEntity paramEntity) throws Exception;
	public ParamEntity getList(ParamEntity paramEntity) throws Exception;

	public ParamEntity doExport(ParamEntity paramEntity) throws Exception;
}