package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import action.LoginAction;
import model.Account;

public class LoginInterceptor extends AbstractInterceptor implements StrutsStatics {

	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(LoginInterceptor.class);
	private static final String USER_HANDLE = "user";

	@Override
	public void init() {
		log.info("Intializing LoginInterceptor");
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Login Interceptor");
		final ActionContext context = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
		HttpSession session = request.getSession(true);

		Account account = (Account) session.getAttribute(USER_HANDLE);
		if (account == null) {
			if (invocation.getAction().getClass().equals(LoginAction.class)) {
				return invocation.invoke();
			}
			return "login";
		}
		return invocation.invoke();
	}

}
