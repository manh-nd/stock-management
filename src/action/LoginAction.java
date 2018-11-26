package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import model.Account;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private AccountDao accountDao = new AccountDaoImpl();
	private String username;
	private String password;

	public String login() {
		System.out.println("login action");
		Account account = accountDao.findByUsernameAndPassword(username, password);
		if (account == null) {
			addActionMessage("Sai tài khoản hoặc mật khẩu");
			return INPUT;
		}
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		request.getSession().setAttribute("user", account);
		return SUCCESS;
	}

	@Override
	public void validate() {
		System.out.println("validate...");
		if (username == null || username.isEmpty())
			addFieldError("username", "Bạn chưa nhập tài khoản");
		if (password == null || password.isEmpty())
			addFieldError("password", "Bạn chưa nhập mật khẩu");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
