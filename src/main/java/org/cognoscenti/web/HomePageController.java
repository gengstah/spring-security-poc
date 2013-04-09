package org.cognoscenti.web;

import org.cognoscenti.manager.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {
	private AuthenticationManager authenticationManager;
	
	public HomePageController() { }
	
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@RequestMapping(value="/secure/index.html", method=RequestMethod.GET)
	public String displayHomePage(Model model) {
		model.addAttribute("groups", authenticationManager.getGoups());
		
		return "home";
	}
}