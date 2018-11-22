package dto;

import java.util.Date;

/**
 * Lớp rút gọn của lớp Goods dùng để hiển thị dữ liệu trên bảng
 * 
 * @author Manh Nguyen
 *
 */
public class GoodsDto {

	// ID hàng hóa
	private Integer id;
	
	// Mã hàng hóa
	private String code;
	
	// Tên hàng hóa
	private String name;
	
	// Hạn sử dụng
	private Date expiration;
	
	// Hàng tồn kho lấy từ bảng Inventory
	private Integer inStock;

	public GoodsDto() {
		super();
	}

	public GoodsDto(Integer id, String code, String name, Date expiration, Integer inStock) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.expiration = expiration;
		this.inStock = inStock;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public Integer getInStock() {
		return inStock;
	}

	public void setInStock(Integer inStock) {
		this.inStock = inStock;
	}

	@Override
	public String toString() {
		return String.format("GoodsHelper(id=%s, code=%s, name=%s, expiration=%s, inStock=%s)", id, code, name,
				expiration, inStock);
	}

}
