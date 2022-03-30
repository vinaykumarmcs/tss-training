package com.tss.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tss.model.User;
import com.tss.service.UserService;

@Controller
public class UserController {
	private UserService svc;

	public UserController(Connection connection) {
		svc = UserService.init(connection);
	}

	@RequestMapping(value = "/")
	public ModelAndView list(ModelAndView model) throws IOException {
		List<Map<String, Object>> map = svc.list();
		model.addObject("users", map);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute User user) {
		ModelAndView view = new ModelAndView();
		Map<String, Object> res = svc.add(user);
		if (res.containsKey("errors"))
			view.addObject("msg", res.get("errors"));
		else
			view.addObject("msg", "Saved successfully");
		view.setViewName("message");
		return view;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute User user) {
		ModelAndView view = new ModelAndView();
		Map<String, Object> res = svc.update(user);
		if (res.containsKey("errors"))
			view.addObject("msg", res.get("errors"));
		else
			view.addObject("msg", "Updated successfully");
		view.setViewName("message");
		return view;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		Map<String, Object> res = svc.delete(request.getParameter("phone"));
		if (res.containsKey("errors"))
			view.addObject("msg", res.get("errors"));
		else
			view.addObject("msg", "Deleted successfully");
		view.setViewName("message");
		return view;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ModelAndView get(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		Map<String, Object> map = svc.get(request.getParameter("phone"));
		view.addObject("user", map);
		view.setViewName("updateform");
		return view;
	}
}