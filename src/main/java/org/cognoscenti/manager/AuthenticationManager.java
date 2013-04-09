package org.cognoscenti.manager;

import java.util.List;

import org.cognoscenti.security.domain.Group;

public interface AuthenticationManager {
	List<Group> getGoups();
}