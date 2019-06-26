package com.udemy.backendninja.com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


//Errors alternative of myself
@Controller
@RequestMapping("/example4")
public class Example4Controller {

	private static final String RETURN_404_ERROR = "/error/404";
	private static final String RETURN_500_EROOR = "/error/500";
	
	
    @GetMapping("/show404Error")
    public ModelAndView show404Error(){
        ModelAndView mav = new ModelAndView(RETURN_404_ERROR);
        return mav;
    }
    
    @GetMapping("/show500Error")
    public ModelAndView show500Error(){
        ModelAndView mav = new ModelAndView(RETURN_500_EROOR);
        return mav;
    }

}
