package model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="account")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ACCOUNT_ID", unique=true, nullable=false)
	private Integer id;

	@Column(name="ACCOUNT_FULLNAME", nullable=false, length=40)
	private String fullname;

	@Column(name="ACCOUNT_PASSWORD", nullable=false, length=16)
	private String password;

	@Column(name="ACCOUNT_USERNAME", nullable=false, length=16)
	private String username;
	
	@Column(name="ACCOUNT_ACTIVE")
	private Boolean active;
	
	@Column(name="ACCOUNT_ROLES", nullable=false, length=10)
	private String role;
	
	@Column(name="ACCOUNT_REPORT", nullable=true, length=255)
	private String report;

	public Account() {
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

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	@Override
	public String toString() {
		return String.format("Account (id=%s, fullname=%s, password=%s, username=%s, active=%s,roles=%s)", id, fullname,
				password, username, active,role);
	}

}