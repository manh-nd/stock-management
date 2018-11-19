package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import constant.Page;
import util.WebUtil;

@Result(name = "indexPage", location = Page.TEMPLATE_PAGE)
public class HomeAction {

	@Action("/")
	public String goHomePage() {
		HttpServletRequest request = WebUtil.getHttpServletRequest();
		request.setAttribute("title", "Trang chủ");
		request.setAttribute("page", Page.INDEX_PAGE);
		return "indexPage";
	}

}
