/**************************************************************************************************
 * Project
 * Description
 * - Login
 *************************************************************************************************/
package project.app.login;

import org.springframework.beans.factory.annotation.Autowired;

import project.common.extend.BaseAction;
import zebra.config.MemoryBean;
import zebra.util.CommonUtil;

public class LoginAction extends BaseAction {
	@Autowired
	private LoginBiz biz;

	public String index() throws Exception {
		biz.index(paramEntity);
		return "loginPage";
	}
}