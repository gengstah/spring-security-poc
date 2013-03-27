package org.cognoscenti.security.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="GROUPS")
public class Group {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="GROUP_NAME", length=50, nullable=false)
	private String groupName;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name="GROUP_AUTHORITIES", 
				joinColumns=@JoinColumn(name="GROUP_ID", referencedColumnName="ID"),
				inverseJoinColumns=@JoinColumn(name="AUTHORITY", referencedColumnName="AUTHORITY"))
	private List<Authority> authorities;
	
	public Group() { }

	public Long getId() {
		return id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
}