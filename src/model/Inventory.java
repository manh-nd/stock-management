package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the inventory database table.
 * 
 */
@Entity
@Table(name="inventory")
@NamedQuery(name="Inventory.findAll", query="SELECT i FROM Inventory i")
public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="INVENTORY_ID", unique=true, nullable=false)
	private Integer id;

	@Column(name="INVENTORY_QUANTITY", nullable=false)
	private Integer quantity;

	//bi-directional many-to-one association to Good
	@ManyToOne
	@JoinColumn(name="GOODS_ID", nullable=false)
	private Goods goods;

	//bi-directional many-to-one association to Stock
	@ManyToOne
	@JoinColumn(name="STOCK_ID", nullable=false)
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

	public Goods getGood() {
		return this.goods;
	}

	public void setGood(Goods good) {
		this.goods = good;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}