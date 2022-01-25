package zebra.config;

import java.io.File;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import zebra.example.common.module.commoncode.ZebraCommonCodeManager;
import zebra.example.common.module.menu.ZebraMenuManager;
import zebra.util.CommonUtil;

public class AppLoader extends HttpServlet {
	private Logger logger = LogManager.getLogger(this.getClass());
	private ServletContext context;

	public void init(ServletConfig config) throws ServletException {
		try {
			this.context = config.getServletContext();
			executeWorks();
		} catch (Exception ex) {
			logger.error("Application loading failed.");
			logger.error(ex);
		}
	}

	/*!
	 * important : execution order
	 * MemonyBean
	 */
	private void executeWorks() throws Exception {
		MemoryBean.set("applicationRealPath", CommonUtil.replace(context.getRealPath(""), File.separator, "/"));
		MemoryBean.set("applicationSrcPathRoot", CommonUtil.remove((String)MemoryBean.get("applicationRealPath"), "/target/husky/"));
		MemoryBean.set("applicationSrcPathSrc", MemoryBean.get("applicationSrcPathRoot")+"/src");
		MemoryBean.set("applicationSrcPathJava", MemoryBean.get("applicationSrcPathSrc")+"/main/java");
		MemoryBean.set("applicationSrcPathWeb", MemoryBean.get("applicationSrcPathSrc")+"/main/webapp");

		// Framework Menu & CommonCode
		ZebraMenuManager.loadMenu();
		ZebraCommonCodeManager.loadCommonCode();

		MessageManager.loadMessageBundles();
	}
}