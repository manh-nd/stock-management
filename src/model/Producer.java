package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the producer database table.
 * 
 */
@Entity
@Table(name="producer")
@NamedQuery(name="Producer.findAll", query="SELECT p FROM Producer p")
public class Producer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRODUCER_ID", unique=true, nullable=false)
	private Integer id;

	@Column(name="PRODUCER_CODE", nullable=false, length=6)
	private String code;

	@Column(name="PRODUCER_NAME", nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to Good
	@OneToMany(mappedBy="producer")
	private Set<Goods> goods;

	public Producer() {
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
		good.setProducer(this);

		return good;
	}

	public Goods removeGood(Goods good) {
		getGoods().remove(good);
		good.setProducer(null);

		return good;
	}

}