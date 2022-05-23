package project.app.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import project.common.extend.BaseBiz;
import zebra.data.ParamEntity;
import zebra.exception.FrameworkException;

public class LoginBizImpl extends BaseBiz implements LoginBiz {
	public ParamEntity index(ParamEntity paramEntity) throws Exception {
		HttpServletRequest request = paramEntity.getRequest();
		HttpSession session = paramEntity.getSession();
		String language = request.getLocale().getLanguage();

		try {
			session.setAttribute("langCode", language);
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}
}