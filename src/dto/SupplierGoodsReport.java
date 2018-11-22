package dto;

public class SupplierGoodsReport {

	private String name;
	private Long quantity;
	private Long totalValue;

	public SupplierGoodsReport() {
	}

	public SupplierGoodsReport(String name, Long quantity, Long totalValue) {
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

	@Override
	public String toString() {
		return String.format("SupplierGoodsReport (name=%s, quantity=%s, totalValue=%s)", name, quantity, totalValue);
	}

}
