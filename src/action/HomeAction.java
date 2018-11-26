package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import constant.Page;
import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import util.WebUtil;

@ParentPackage("webapp-package")
public class HomeAction extends ActionSupport {

	private static final long serialVersionUID = 4863847536708834980L;
	
	private AccountDao accountDao = new AccountDaoImpl();

	@Action(value = "/", results = @Result(name = SUCCESS, location = Page.TEMPLATE_PAGE))
	public String goHomePage() {
		HttpServletRequest request = WebUtil.getHttpServletRequest();
		request.setAttribute("title", "Trang chủ");
		request.setAttribute("page", Page.INDEX_PAGE);
		accountDao.findAll();
		return SUCCESS;
	}

}
