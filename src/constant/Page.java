package constant;

/**
 * Lớp này lưu trữ đường dẫn các trang jsp.
 * 
 * @author Manh Nguyen
 *
 */
public interface Page {

	// Dùng chung
	String TEMPLATE_PAGE = "/WEB-INF/pages/template.jsp";

	String INDEX_PAGE = "/WEB-INF/pages/index.jsp";

	String LOGIN_PAGE = "/WEB-INF/pages/login.jsp";

	// Manh - Goods
	String GOODS_LIST_PAGE = "/WEB-INF/pages/goods/goods_list.jsp";
	String GOODS_FORM_PAGE = "/WEB-INF/pages/goods/goods_form.jsp";

	// Mậu - Producer
	String PRODUCER_LIST_PAGE = "/WEB-INF/pages/producer/producer_list.jsp";
	String PRODUCER_FORM_PAGE = "/WEB-INF/pages/producer/producer_form.jsp";
	
	// Dương
	
	// Văn 
}
