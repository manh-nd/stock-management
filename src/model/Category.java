package model;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.struts2.json.annotations.JSON;

import java.util.Set;

@Entity
@Table(name = "category")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CATEGORY_ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "CATEGORY_CODE", unique = true, nullable = false, length = 6)
	private String code;

	@Column(name = "CATEGORY_NAME", unique = true, nullable = false, length = 45)
	private String name;

	@Column(name = "CATEGORY_ACTIVE", insertable=false)
	private Boolean active;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Set<Goods> goods;

	public Category() {
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

	@JSON(serialize = false)
	public Set<Goods> getGoods() {
		return this.goods;
	}

	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}

	public Goods addGood(Goods good) {
		getGoods().add(good);
		good.setCategory(this);

		return good;
	}

	public Goods removeGood(Goods good) {
		getGoods().remove(good);
		good.setCategory(null);

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
		return String.format("Category (id=%s, code=%s, name=%s, active=%s)", id, code, name, active);
	}

}