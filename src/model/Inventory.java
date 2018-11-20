package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "inventory", uniqueConstraints = { @UniqueConstraint(columnNames = { "STOCK_ID", "GOODS_ID" }) })
public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INVENTORY_ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "INVENTORY_QUANTITY", unique = true, nullable = false)
	private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "GOODS_ID", unique = true, nullable = false)
	private Goods goods;

	@ManyToOne
	@JoinColumn(name = "STOCK_ID", nullable = false)
	private Stock stock;

	public Inventory() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return String.format("Inventory(id=%s, quantity=%s, goods=%s, stock=%s)", id, quantity, goods, stock);
	}

}