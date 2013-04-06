package org.cognoscenti.web;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cognoscenti.security.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {
	@PersistenceContext
	private EntityManager entityManager;
	
	@RequestMapping(value="/secure/index.html", method=RequestMethod.GET)
	public String displayHomePage() {
		entityManager.createQuery("SELECT user from User user", User.class);
		return "home";
	}
}