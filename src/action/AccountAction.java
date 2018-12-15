package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.*;
import org.hibernate.validator.Valid;

import com.opensymphony.xwork2.ActionSupport;

import constant.Page;
import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import model.Account;
import util.WebUtil;

@ParentPackage("default")
@Namespace("/account")
@ResultPath("/")
public class AccountAction extends ActionSupport implements IAction {


	private static final long serialVersionUID = 5308858196899901212L;
	private AccountDao accountDao = new AccountDaoImpl();
	
	@Valid
	private Account account = new Account();

	@Action(value = "list", results = @Result(name = SUCCESS, location = Page.ACCOUNT_LIST))
	public String list() {
		System.out.println("account list");
		return SUCCESS;
	}

	@Action(value = "add", results = @Result(name = SUCCESS, location = Page.ACCOUNT_FORM))
	public String add() {
		return SUCCESS;
	}

	@Action(value = "edit", results = @Result(name = SUCCESS, location = Page.ACCOUNT_FORM))
	public String edit() {
		Integer id = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("id"));
		account = accountDao.findById(id);
		return SUCCESS;
	}

	@Action(value = "delete", results = @Result(name = SUCCESS, location = "list", type = "redirect"))
	public String delete() {
		Integer id = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("id"));
		account = accountDao.findById(id);
		
		accountDao.delete(account);
		return SUCCESS;
	}

	
	@Action(value = "save", interceptorRefs = @InterceptorRef("defaultStackHibernateStrutsValidation"), results = {
			@Result(name = SUCCESS, location = "list", type = "redirect"),
			@Result(name = INPUT, location = Page.ACCOUNT_FORM) })
	public String save() {
		
		String username = account.getUsername();
		System.out.println(username);
		
		if(accountDao.fillbyUsername(username) !=null) {
			addFieldError("account.username", "Tài khoản đã tồn tại. Vui lòng sử dụng tên khác !");
			return INPUT;
		}
		else {
		System.out.println(account);
		accountDao.saveOrUpdate(account);
		System.out.println("insert");
		return SUCCESS;
		}
	}

	@Action(value = "block", results = @Result(name = SUCCESS, location = Page.ACCOUNT_BLOCK))
	public String block() {
		Integer id = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("id"));
		account = accountDao.findById(id);
		return SUCCESS;
	}
	
	@Action(value = "update", interceptorRefs = @InterceptorRef("defaultStackHibernateStrutsValidation"), results = {
			@Result(name = SUCCESS, location = "list", type = "redirect"),
			@Result(name = INPUT, location = Page.ACCOUNT_BLOCK) })
	public String update() {
		System.out.println(account);
		accountDao.saveOrUpdate(account);
		System.out.println("insert");
		return SUCCESS;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Account> getAccountList() {
		return accountDao.findAll();
	}
	
	public Map<Boolean, String> getActives() {
		HashMap<Boolean, String> actives = new HashMap<>();
		actives.put(true, "Hoạt động");
		actives.put(false, "Khóa");
		return actives;
	}
	@Override
	public void validate() {
		
//		String fullname = account.getFullname();
//		String password = account.getPassword();
// 		if(fullname.length() < 6) {
//			addFieldError("account.fullname", "Ten day du phai lon hon 6 ki tu");
//		}
// 		if(password.length() < 6) {
// 			addFieldError("account.password", "Mat khau phai lon hon 6 ki tu");
// 		}
		System.out.println("Validate Account...");
		
	}
}
