package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reference database table.
 * 
 */
@Entity
@Table(name="reference")
@NamedQuery(name="Reference.findAll", query="SELECT r FROM Reference r")
public class Reference implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="REFERENCE_ID", unique=true, nullable=false)
	private Integer id;

	@Column(name="REFERENCE_ACTIVE")
	private Boolean active;

	@Column(name="REFERENCE_NUMBERVALUE", length=45)
	private String numberValue;

	@Column(name="REFERENCE_SECTOR", length=8)
	private String sector;

	@Column(name="REFERENCE_TEXTVALUE", length=23)
	private String textValue;

	public Reference() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getNumberValue() {
		return this.numberValue;
	}

	public void setNumberValue(String numberValue) {
		this.numberValue = numberValue;
	}

	public String getSector() {
		return this.sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getTextValue() {
		return this.textValue;
	}

	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}

}