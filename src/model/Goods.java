package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.struts2.json.annotations.JSON;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Range;

@Entity
@Table(name = "goods")
public class Goods implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GOODS_ID", unique = true, nullable = false)
	private Integer id;

	@NotEmpty(message = "Mã hàng hóa không được trống!")
	@Length(min = 3, max = 8, message = "Mã hàng hóa phải trong khoảng từ 3 - 8 ký tự!")
	@Column(name = "GOODS_CODE", unique = true, nullable = false, length = 8)
	private String code;

	@NotNull(message = "Phân loại không được để trống!")
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	private Category category;

	@NotNull(message = "Hãng sản xuất không được để trống!")
	@ManyToOne
	@JoinColumn(name = "PRODUCER_ID", nullable = false)
	private Producer producer;

	@NotNull(message = "Nhà cung cấp không được để trống!")
	@ManyToOne
	@JoinColumn(name = "SUPPLIER_ID", nullable = false)
	private Supplier supplier;

	@NotEmpty(message = "Tên hàng hóa không được để trống!")
	@Length(min = 6, max = 64, message = "Tên hàng hóa phải trong khoảng 6 - 64 ký tự!")
	@Column(name = "GOODS_NAME", nullable = false, length = 64)
	private String name;

	@Column(name = "GOODS_FEATURE", length = 45)
	private String feature;

	@Column(name = "GOODS_LOTNUMBER", length = 16)
	private String lotNumber;

	@Temporal(TemporalType.DATE)
	@Column(name = "GOODS_EXPIRATION")
	private Date expiration;

	@NotNull(message = "Giá nhập không được để được trống!")
	@Range(min = 0, max = Integer.MAX_VALUE, message = "Giá nhập không hợp lệ!")
	@Column(name = "GOODS_IMPORT_PRICE", nullable = false)
	private Integer importPrice;

	@NotNull(message = "Giá bán không được để được trống!")
	@Range(min = 0, max = Integer.MAX_VALUE, message = "Giá bán không hợp lệ!")
	@Column(name = "GOODS_EXPORT_PRICE", nullable = false)
	private Integer exportPrice;

	@NotEmpty(message = "Đơn vị không được để trống!")
	@Length(min = 3, max = 16, message = "Đơn vị tính phải từ 3 - 16 ký tự!")
	@Column(name = "GOODS_UNIT", nullable = false, length = 16)
	private String unit;

	@Column(name = "GOODS_NEW_BRAND", nullable = false)
	private Boolean newBrand;

	@Column(name = "GOODS_ACTIVE", insertable = false)
	private Boolean active;

	@OneToMany(mappedBy = "goods", cascade = CascadeType.ALL)
	private Set<Inventory> inventories;

	public Goods() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getExpiration() {
		return this.expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public Integer getExportPrice() {
		return this.exportPrice;
	}

	public void setExportPrice(Integer exportPrice) {
		this.exportPrice = exportPrice;
	}

	public String getFeature() {
		return this.feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public Integer getImportPrice() {
		return this.importPrice;
	}

	public void setImportPrice(Integer importPrice) {
		this.importPrice = importPrice;
	}

	public String getLotNumber() {
		return this.lotNumber;
	}

	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getNewBrand() {
		return this.newBrand;
	}

	public void setNewBrand(Boolean newBrand) {
		this.newBrand = newBrand;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Producer getProducer() {
		return this.producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@JSON(serialize = false)
	public Set<Inventory> getInventories() {
		return this.inventories;
	}

	public void setInventories(Set<Inventory> inventories) {
		this.inventories = inventories;
	}

	public Inventory addInventory(Inventory inventory) {
		getInventories().add(inventory);
		inventory.setGoods(this);

		return inventory;
	}

	public Inventory removeInventory(Inventory inventory) {
		getInventories().remove(inventory);
		inventory.setGoods(null);

		return inventory;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return String.format(
				"Goods (id=%s, code=%s, category=%s, producer=%s, supplier=%s, name=%s, feature=%s, lotNumber=%s, expiration=%s, importPrice=%s, exportPrice=%s, unit=%s, newBrand=%s, active=%s)",
				id, code, category, producer, supplier, name, feature, lotNumber, expiration, importPrice, exportPrice,
				unit, newBrand, active);
	}

}