package project.app.login;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;

import de.taimos.totp.TOTP;
import project.common.extend.BaseBiz;
import project.common.module.commoncode.CommonCodeManager;
import zebra.config.MemoryBean;
import zebra.data.DataSet;
import zebra.data.ParamEntity;
import zebra.data.QueryAdvisor;
import zebra.exception.FrameworkException;
import zebra.util.CommonUtil;
import zebra.util.ConfigUtil;
import zebra.util.FileUtil;

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