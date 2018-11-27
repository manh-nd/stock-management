package action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.hibernate.validator.Valid;

import com.opensymphony.xwork2.ActionSupport;

import constant.Page;
import dto.GoodsDto;
import model.Category;
import model.Goods;
import model.Inventory;
import model.Producer;
import model.Stock;
import model.Supplier;
import service.GoodsService;
import service.GoodsServiceImpl;
import util.WebUtil;

/**
 * Action Hàng hóa
 * 
 * @author Manh Nguyen
 *
 */
@ParentPackage("goods-package")
@Namespace("/goods")
@ResultPath("/")
public class GoodsAction extends ActionSupport implements IAction {

	private static final long serialVersionUID = -5799607767607577952L;

	// Goods service
	private GoodsService goodsService = new GoodsServiceImpl();

	private List<GoodsDto> goodsList = new ArrayList<>();

	@Valid
	private Goods goodsBean = new Goods();
	private Stock stockBean = new Stock();
	private Inventory inventoryBean = new Inventory();
	private InputStream inputStream;

	@Action(value = "list", results = { @Result(name = SUCCESS, location = Page.GOODS_LIST_PAGE) })
	public String list() {
		String stockIdParam = WebUtil.getHttpServletRequest().getParameter("stockId");
		if (stockIdParam != null) {
			try {
				Integer stockId = Integer.parseInt(stockIdParam);
				goodsList = goodsService.findGoodsByStockId(stockId);
			} catch (Exception e) {
			}
		}
		return SUCCESS;
	}

	@Action(value = "add", results = { @Result(name = SUCCESS, location = Page.GOODS_FORM_PAGE) })
	public String add() {
		String stockIdParam = WebUtil.getHttpServletRequest().getParameter("stockId");
		Integer stockId = Integer.parseInt(stockIdParam);
		stockBean = goodsService.findByStockId(stockId);
		inventoryBean = new Inventory();
		return SUCCESS;
	}

	@Action(value = "edit", results = { @Result(name = SUCCESS, location = Page.GOODS_FORM_PAGE) })
	public String edit() {
		Integer stockId = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("stockId"));
		Integer id = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("id"));
		stockBean = goodsService.findByStockId(stockId);
		goodsBean = goodsService.findById(id);
		inventoryBean = goodsService.findInventoryByStockIdAndGoodsId(stockId, id);
		return SUCCESS;
	}

	@Action(value = "delete", results = { @Result(name = SUCCESS, location = "list", type = "redirect") })
	public String delete() {
		Integer id = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("id"));
		goodsBean = goodsService.findById(id);
		goodsService.delete(goodsBean);
		return SUCCESS;
	}

	@Action(value = "save", interceptorRefs = @InterceptorRef("defaultStackHibernateStrutsValidation"), results = {
			@Result(name = SUCCESS, location = "list", type = "redirect"),
			@Result(name = INPUT, location = Page.GOODS_FORM_PAGE) })
	public String save() {

		inventoryBean.setGoods(goodsBean);
		inventoryBean.setStock(stockBean);

		Set<Inventory> inventories = new HashSet<>();
		inventories.add(inventoryBean);
		goodsBean.setInventories(inventories);

		goodsService.saveOrUpdate(goodsBean);
		System.out.println("Saved Goods Bean: " + goodsBean);

		return SUCCESS;
	}

	@Action(value = "/export", results = @Result(name = SUCCESS, type = "stream", params = { "contentType",
			"application/vnd.ms-excel", "inputName", "inputStream", "contentDisposition",
			"attachment;filename=\"export.xls\"", "bufferSize", "1024" }))
	public String exportInExcel() {
		try (HSSFWorkbook workbook = new HSSFWorkbook()) {
			Integer stockId = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("stockId"));
			String stockName = goodsService.findByStockId(stockId).getName();
			goodsList = goodsService.findGoodsByStockId(stockId);
			HSSFSheet sheet = workbook.createSheet(stockName);

			Row rowHeading = sheet.createRow(0);
			rowHeading.createCell(0).setCellValue("STT");
			rowHeading.createCell(1).setCellValue("Mã hàng hóa");
			rowHeading.createCell(2).setCellValue("Tên hàng hóa");
			rowHeading.createCell(3).setCellValue("Hạn sử dụng");
			rowHeading.createCell(4).setCellValue("Tồn kho");

			for (int rowIndex = 1; rowIndex <= goodsList.size(); rowIndex++) {
				Row row = sheet.createRow(rowIndex);
				GoodsDto g = goodsList.get(rowIndex - 1);
				row.createCell(0).setCellValue(rowIndex);
				row.createCell(1).setCellValue(g.getCode());
				row.createCell(2).setCellValue(g.getName());
				if (g.getExpiration() != null)
					row.createCell(3).setCellValue(new SimpleDateFormat("dd/MM/yyy").format(g.getExpiration()));
				row.createCell(4).setCellValue(g.getInStock());
			}

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			workbook.write(outputStream);
			setInputStream(new ByteArrayInputStream(outputStream.toByteArray()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public Goods getGoodsBean() {
		return goodsBean;
	}

	public void setGoodsBean(Goods goodsBean) {
		this.goodsBean = goodsBean;
	}

	public List<GoodsDto> getGoodsList() {
		return goodsList;
	}

	public List<Stock> getStockList() {
		return goodsService.getStocks();
	}

	public List<Category> getCategoryList() {
		return goodsService.getCategories();
	}

	public List<Supplier> getSupplierList() {
		return goodsService.getSuppliers();
	}

	public List<Producer> getProducerList() {
		return goodsService.getProducers();
	}

	public Stock getStockBean() {
		return stockBean;
	}

	public void setStockBean(Stock stockBean) {
		this.stockBean = stockBean;
	}

	public Inventory getInventoryBean() {
		return inventoryBean;
	}

	public void setInventoryBean(Inventory inventoryBean) {
		this.inventoryBean = inventoryBean;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public Date getMinValue() {
		return new Date();
	}
	
	public Date getMaxValue() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2020, 11, 30);
		return calendar.getTime();
	}
	
	public Map<Boolean, String> getActives() {
		HashMap<Boolean, String> actives = new HashMap<>();
		actives.put(true, "Hoạt động");
		actives.put(false, "Tạm dừng");
		return actives;
	}

	@Override
	public void validate() {
		System.out.println("Validate Goods....");
	}

}
