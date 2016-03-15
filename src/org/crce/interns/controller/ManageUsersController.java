package org.crce.interns.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.crce.interns.model.User;
import org.crce.interns.service.ManageUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManageUsersController {

	@Autowired
	private ManageUsersService crudService;

	@RequestMapping(value = "/view-candidate.html", method = RequestMethod.GET)
	public ModelAndView gotoviewcandidate() {
		ModelAndView model = null;
		model = new ModelAndView("view-candidate");
		return model;
	}

	// @SuppressWarnings("unused")

	@RequestMapping(value = "/list.html", method = RequestMethod.POST)
	public ModelAndView viewcandidate(@RequestParam("company") String company) {
		ModelAndView model;

		System.out.println("inside controller"+company);

		// crudService.retreiveDetails(company);
		
		 // if(result.hasErrors()){ model=new ModelAndView("view-candidate");
		  //return model; }
		 
		model = new ModelAndView("candidate-list");
		//Map<String, Object> x = new HashMap<String, Object>();
		//x.put("users", crudService.retreiveDetails(company));
		 List<User> userList=new ArrayList<User>();
		 userList.addAll(crudService.retreiveDetails(company));
		 for(User d:userList) System.out.println(d.getUserName());
		 model.addObject(userList);
		//model.addObject(x);
		return model;
	}

	@RequestMapping(value = "/showlist.html", method = RequestMethod.POST )
	public ModelAndView cruddetails(@RequestParam(value = "option") String option) {
		ModelAndView model;
		if (option.equals("Add"))
			model = new ModelAndView("add-candidate");
		else if (option.equals("Delete"))
			model = new ModelAndView("delete-candidate");
		else
			model = null;

		return model;
	}

	@RequestMapping(value = "/addcandidate.html", method = RequestMethod.POST)
	public ModelAndView addcandidate(@RequestParam("name") String name, @RequestParam("company") String company) {
		ModelAndView model;
		User user = new User();
		user.setUserName(name);
		user.setCompany(company);
		System.out.println(user.getUserName());
		crudService.createDetails(user);
		model = new ModelAndView("add-success");
		return model;
	}

	@RequestMapping(value = "/deletecandidate.html", method = RequestMethod.POST)
	public ModelAndView deletecandidate(@RequestParam("name") String name, @RequestParam("company") String company) {
		ModelAndView model;
		User user = new User();
		user.setUserName(name);
		user.setCompany(company);
		crudService.deleteDetails(user);
		model = new ModelAndView("delete-success");
		return model;
	}

}
