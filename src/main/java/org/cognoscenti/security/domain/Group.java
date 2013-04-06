package org.cognoscenti.security.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@OneToMany(mappedBy="group", fetch=FetchType.EAGER)
	private Set<Authority> authorities;
	
	@OneToMany(mappedBy="group", fetch=FetchType.EAGER)
	private Set<User> users;
	
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

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}