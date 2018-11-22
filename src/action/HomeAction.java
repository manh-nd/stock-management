package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import constant.Page;
import dao.GoodsDao;
import dao.impl.GoodsDaoImpl;
import util.WebUtil;

@ParentPackage("default-package")
@Result(name = "indexPage", location = Page.TEMPLATE_PAGE)
public class HomeAction {
	
	private GoodsDao goodsDao = new GoodsDaoImpl();

	@Action("/")
	public String goHomePage() {
		HttpServletRequest request = WebUtil.getHttpServletRequest();
		request.setAttribute("title", "Trang chủ");
		request.setAttribute("page", Page.INDEX_PAGE);
		
		System.out.println(goodsDao.getExpirationGoodsReport().size());
		
		return "indexPage";
	}

}
