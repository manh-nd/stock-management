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
	String CATEGORY_REPORT = "/WEB-INF/pages/report/category_report.jsp";
	String SUPPLIER_REPORT = "/WEB-INF/pages/report/supplier_report.jsp";
	String EXPIRATION_GOODS_REPORT = "/WEB-INF/pages/report/expiration_goods_report.jsp";

	// Mậu - Producer
	String PRODUCER_LIST_PAGE = "/WEB-INF/pages/producer/producer_list.jsp";
	String PRODUCER_FORM_PAGE = "/WEB-INF/pages/producer/producer_form.jsp";
	
	// Dương
	
	// Văn 
}
