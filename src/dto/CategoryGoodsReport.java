package dto;

public class CategoryGoodsReport {

	private String name;
	private Long quantity;
	private Long totalValue;

	public CategoryGoodsReport() {
		super();
	}

	public CategoryGoodsReport(String name, Long quantity, Long totalValue) {
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

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Long totalValue) {
		this.totalValue = totalValue;
	}

}
