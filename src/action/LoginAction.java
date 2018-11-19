package action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import constant.Page;

@Results(value = { @Result(name = "loginPage", location = Page.LOGIN_PAGE),
		@Result(name = "login", location = "loginPage", type = "redirect") })
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Action("/sign-in")
	public String goLoginPage() {
		return "loginPage";
	}

	@Action(value = "/login")
	public String login() {
		ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		return "login";
	}

	@Override
	public void validate() {

	}

}
