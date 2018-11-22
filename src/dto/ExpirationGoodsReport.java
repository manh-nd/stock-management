package dto;

import java.util.Date;

public class ExpirationGoodsReport {

	private String code;
	private String name;
	private String category;
	private String supplier;
	private String stock;
	private Date expiration;
	private Integer quantity;

	public ExpirationGoodsReport() {
	}

	public ExpirationGoodsReport(String code, String name, String category, String supplier, String stock,
			Date expiration, Integer quantity) {
		super();
		this.code = code;
		this.name = name;
		this.category = category;
		this.supplier = supplier;
		this.stock = stock;
		this.expiration = expiration;
		this.quantity = quantity;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
