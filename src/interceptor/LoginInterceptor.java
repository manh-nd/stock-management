package interceptor;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsStatics;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;

import com.opensymphony.xwork2.interceptor.AbstractInterceptor;



import action.LoginAction;

import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import model.Account;

public class LoginInterceptor extends AbstractInterceptor implements StrutsStatics {
	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(LoginInterceptor.class);
	private static final String USER_HANDLE = "user";
	AccountDao accountDAO = new AccountDaoImpl();

	private List<String> allowedRoles = Collections.emptyList();
	private List<String> disallowedRoles = Collections.emptyList();

	protected List<String> stringToList(String val) {
		if (val != null) {
			String[] list = val.split("[ ]*,[ ]*");
			return Arrays.asList(list);
		} else {
			return Collections.emptyList();
		}
	}

	public void setAllowedRoles(String roles) {
		this.allowedRoles = stringToList(roles);
	}

	public void setDisallowedRoles(String roles) {
		this.disallowedRoles = stringToList(roles);
	}

	protected boolean isAllowed(HttpServletRequest request, Object action) {
		HttpSession session = request.getSession(false);
		boolean result = false;
		Account loginUser = null;
		if (session != null) {
			loginUser = (Account) session.getAttribute("LOGIN_USER");
		}

		if (allowedRoles.size() > 0) {
			if (session == null || loginUser == null) {
				return result;
			}
			for (String role : allowedRoles) {
				if (role.equalsIgnoreCase(loginUser.getRole())) {
					result = true;
				}
			}
			return result;
		} else if (disallowedRoles.size() > 0) {
			if (session != null || loginUser != null) {
				for (String role : disallowedRoles) {
					if (role.equalsIgnoreCase(loginUser.getRole())) {
						return false;
					}
				}
			}
		}
		return true;
	}

	@Override
	public void init() {
		log.info("Intializing LoginInterceptor");
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Login Interceptor");
		final ActionContext context = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) context.get(HTTP_RESPONSE);
		HttpSession session = request.getSession(true);

		Account account = (Account) session.getAttribute(USER_HANDLE);
		if (account == null) {
			if (invocation.getAction().getClass().equals(LoginAction.class)) {
				return invocation.invoke();
			}
			return "login";
		}
		else if(account.getActive() == false) {
			session.invalidate();
			return "active";
		}
		else if(!isAllowed(request, invocation.getAction())){
			System.out.println("False");
            return handleRejection(invocation, response);
		}
		return invocation.invoke();
	}
	
	protected String handleRejection(ActionInvocation invocation, HttpServletResponse response) throws Exception {
        response.sendError(HttpServletResponse.SC_FORBIDDEN);
        return null;
    }

}
