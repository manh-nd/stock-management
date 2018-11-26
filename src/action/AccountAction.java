package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import model.Account;

@ParentPackage("account-package")
@Namespace("/account")
public class AccountAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private AccountDao accountDao = new AccountDaoImpl();

	private String currentPassword;
	private String newPassword;
	private String verifyPassword;

	public String logout() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		request.getSession().invalidate();
		return SUCCESS;
	}

	public String goPasswordForm() {
		return SUCCESS;
	}

	public String changePassword() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		Account account = (Account) request.getSession().getAttribute("user");
		accountDao.changePassword(account.getId(), newPassword);
		return SUCCESS;
	}

	@Override
	public void validate() {
		System.out.println("validation password");
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		Account account = (Account) request.getSession().getAttribute("user");
		if(!currentPassword.equals(account.getPassword()))
			addFieldError("currentPassword", "Mật khẩu hiện tại không đúng!");
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

}
