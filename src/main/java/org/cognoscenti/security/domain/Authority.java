package org.cognoscenti.security.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="AUTHORITIES")
public class Authority {
	@Id
	@Column(length=50, nullable=false)
	private String authority;
	
	@ManyToOne(optional=false)
	@JoinTable(name="GROUP_AUTHORITIES", 
			joinColumns=@JoinColumn(name="AUTHORITY", referencedColumnName="AUTHORITY"),
			inverseJoinColumns=@JoinColumn(name="GROUP_ID", referencedColumnName="ID"))
	private Group group;
	
	public Authority() { }

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
}