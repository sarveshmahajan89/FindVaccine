package com.github.ssoni.controller;

import com.github.ssoni.batch.bean.Footer;
import com.github.ssoni.entity.CommonData;
import com.github.ssoni.repository.CommonDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@SessionAttributes("footer")
public class WelcomeController {

	@Autowired
	CommonDataRepo commonDataRepo;

	public static int totalVisits;
	public static int totalAdded;

	@GetMapping({"/welcome","/"})
	public String showWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUserName());
		totalVisits++;
		return "welcome";
	}


//	@PostConstruct
//	public void update(){
//		List<CommonData> list = commonDataRepo.findAll();
//		totalVisits=list.get(0).getTotalvalue();
//		totalAdded=list.get(0).getRegisteredVal();
//	}

	@ModelAttribute("footer")
	public Footer footer() {
		return new Footer(totalVisits,totalAdded);
	}

	private String getLoggedinUserName() {
//		Object principal = SecurityContextHolder.getContext()
//				.getAuthentication().getPrincipal();
//
//		if (principal instanceof UserDetails) {
//			return ((UserDetails) principal).getUsername();
//		}
		return "Guest";
	}

}
