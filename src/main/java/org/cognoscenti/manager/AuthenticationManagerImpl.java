package org.cognoscenti.manager;

import java.util.List;

import org.cognoscenti.dao.DataAccessObject;
import org.cognoscenti.security.domain.Group;

public class AuthenticationManagerImpl implements AuthenticationManager {
	private DataAccessObject dao;
	
	public AuthenticationManagerImpl() { }
	
	public void setDao(DataAccessObject dao) {
		this.dao = dao;
	}

	@Override
	public List<Group> getGoups() {
		return dao.findAll(Group.class);
	}
}