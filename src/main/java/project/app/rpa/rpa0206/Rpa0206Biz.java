/**************************************************************************************************
 * project
 * Description - Rpa0206 - Profit And Loss Statement
 *	- Generated by Source Generator
 *************************************************************************************************/
package project.app.rpa.rpa0206;

import zebra.data.ParamEntity;

public interface Rpa0206Biz {
	public ParamEntity getDefault(ParamEntity paramEntity) throws Exception;
	public ParamEntity getList(ParamEntity paramEntity) throws Exception;

	public ParamEntity doExport(ParamEntity paramEntity) throws Exception;
}