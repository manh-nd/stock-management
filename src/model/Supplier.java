package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

/**
 * Nhà cung cấp
 */
@Entity
@Table(name = "supplier")
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUPPLIER_ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "SUPPLIER_CODE", unique = true, nullable = false, length = 6)
	private String code;

	@Column(name = "SUPPLIER_NAME", unique = true, nullable = false, length = 45)
	private String name;

	@Column(name = "SUPPLIER_ACTIVE")
	private Boolean active;

	@OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
	private Set<Goods> goods;

	public Supplier() {
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

	public Set<Goods> getGoods() {
		return this.goods;
	}

	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}

	public Goods addGood(Goods good) {
		getGoods().add(good);
		good.setSupplier(this);

		return good;
	}

	public Goods removeGood(Goods good) {
		getGoods().remove(good);
		good.setSupplier(null);

		return good;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return String.format("Supplier (id=%s, code=%s, name=%s, active=%s)", id, code, name, active);
	}

}