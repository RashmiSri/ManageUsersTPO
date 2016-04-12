package org.crce.interns.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.crce.interns.beans.UserBean;
import org.crce.interns.model.Company;
import org.crce.interns.model.User;
import org.crce.interns.service.ManageUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
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
		 
		model = new ModelAndView("candidate-list");
		 List<User> userList=new ArrayList<User>();
		 userList.addAll(crudService.retreiveDetails(company));
		 for(User d:userList) System.out.println(d.getUsername());
		 model.addObject(userList);
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
		UserBean userBean = new UserBean();
		userBean.setUsername(name);
		userBean.setCompany_id(company);
		System.out.println(userBean.getUsername());
		crudService.createDetails(userBean);
		model = new ModelAndView("add-success");
		return model;
	}

	@RequestMapping(value = "/deletecandidate.html", method = RequestMethod.POST)
	public ModelAndView deletecandidate(@RequestParam("name") String name, @RequestParam("company") String company) {
		ModelAndView model;
		UserBean userBean = new UserBean();
		userBean.setUsername(name);
		userBean.setCompany_id(company);
		crudService.deleteDetails(userBean);
		model = new ModelAndView("delete-success");
		return model;
	}

}
