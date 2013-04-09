package org.cognoscenti.security.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	@Id
	@Column(length=50, nullable=false)
	private String username;

	@Column(length=50, nullable=false)
	private String password;
	
	@Column(nullable=false)
	private Boolean enabled;
	
	@ManyToOne(optional=false)
	@JoinTable(name="GROUP_MEMBERS",
			joinColumns=@JoinColumn(name="USERNAME", referencedColumnName="USERNAME"),
			inverseJoinColumns=@JoinColumn(name="GROUP_ID", referencedColumnName="ID"))
	private Group group;
	
	public User() { }
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
}