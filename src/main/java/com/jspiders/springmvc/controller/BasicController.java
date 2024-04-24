package com.jspiders.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BasicController {

	@RequestMapping("/basic/{userId}")
	public String getValue(@PathVariable("userId") int id,Model model) {
		System.out.println(id);
		model.addAttribute("message", id);
		return "basic";
	}
}
