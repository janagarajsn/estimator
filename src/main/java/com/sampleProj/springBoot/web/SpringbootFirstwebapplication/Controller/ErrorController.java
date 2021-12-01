package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class ErrorController {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest req,Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception",ex.getStackTrace());
		mv.addObject("URL",req.getRequestURL());
		mv.setViewName("Error");
		return mv;
		
	}

}
