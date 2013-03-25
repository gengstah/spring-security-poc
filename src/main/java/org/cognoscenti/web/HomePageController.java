package org.cognoscenti.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {
	@RequestMapping(value="/index.html", method=RequestMethod.GET)
	public String displayHomePage() {
		return "home";
	}
}