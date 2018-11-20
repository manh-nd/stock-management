package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * The persistent class for the stock database table.
 * 
 */
@Entity
@Table(name = "stock")
@NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STOCK_ID", unique = true, nullable = false)
	private Integer id;

	@NotNull(message = "Mã kho không được để trống!")
	@Length(min = 3, max = 6, message = "Mã kho từ 3 - 6 ký tự!")
	@Column(name = "STOCK_CODE", unique = true, nullable = false, length = 6)
	private String code;

	@NotNull(message = "Tên kho không được để trống!")
	@Length(min = 6, max = 45, message = "Mã kho từ 6 - 45 ký tự!")
	@Column(name = "STOCK_NAME", nullable = false, length = 45)
	private String name;

	@OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
	private Set<Inventory> inventories;

	public Stock() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Inventory> getInventories() {
		return this.inventories;
	}

	public void setInventories(Set<Inventory> inventories) {
		this.inventories = inventories;
	}

	public Inventory addInventory(Inventory inventory) {
		getInventories().add(inventory);
		inventory.setStock(this);

		return inventory;
	}

	public Inventory removeInventory(Inventory inventory) {
		getInventories().remove(inventory);
		inventory.setStock(null);

		return inventory;
	}

	@Override
	public String toString() {
		return String.format("Stock(id=%s, code=%s, name=%s)", id, code, name);
	}

}