package org.crce.interns.controller;
import java.util.ArrayList;
import java.util.List;

import org.crce.interns.model.User;
import org.crce.interns.service.ManageUsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManageUsersController {
	
	private ManageUsersService crudService;
	@RequestMapping(value="/view-candidate.html", method = RequestMethod.GET)
	public ModelAndView gotoviewcandidate(){
		ModelAndView model=null;
		model = new ModelAndView("view-candidate");		
		return model;
	}
	
	@RequestMapping(value="/candidates-list.html", method ={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView viewcandidate(@RequestParam("company") String company){
		ModelAndView model;
		//crudService.retreiveDetails(company);
		model= new ModelAndView("candidate-list");
		if(model==null) System.out.println("returned null *************");
		List<User> userList=new ArrayList<User>();
		userList.addAll(crudService.retreiveDetails(company));
		model.addObject(userList);
		return model;
	}
	
	@RequestMapping(value="/crudcandidate.html", method = RequestMethod.POST)
	public ModelAndView cruddetails(@RequestParam(value="option") String option){
		ModelAndView model;
		if(option.equals("Add"))
		model= new ModelAndView("add-candidate");
		else if(option.equals("Delete"))
		model= new ModelAndView("delete-candidate");
		else
		model= null;
		
		return model;
	}

	@RequestMapping(value="/addcandidate.html", method = RequestMethod.POST)
	public ModelAndView addcandidate(@RequestParam("name") String name,@RequestParam("company") String company){
		ModelAndView model;
		User user=new User();
		user.setUserName(name);
		user.setCompany(company);
		crudService.createDetails(user);
		model= new ModelAndView("add-success");
		return model;
	}
	
	@RequestMapping(value="/deletecandidate.html", method = RequestMethod.POST)
	public ModelAndView deletecandidate(@RequestParam("name") String name,@RequestParam("company") String company){
		ModelAndView model;
		User user=new User();
		user.setUserName(name);
		user.setCompany(company);
		crudService.deleteDetails(user);
		model= new ModelAndView("delete-success");
		return model;
	}
	

	
}
