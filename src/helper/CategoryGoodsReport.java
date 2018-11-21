package helper;

public class CategoryGoodsReport {

	private String name;
	private Integer quantity;
	private Integer totalValue;

	public CategoryGoodsReport() {
		super();
	}

	public CategoryGoodsReport(String name, Integer quantity, Integer totalValue) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.totalValue = totalValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Integer totalValue) {
		this.totalValue = totalValue;
	}

}
