package com.udemy.backendninja.com.udemy.backendninja.controller;

import com.udemy.backendninja.com.udemy.backendninja.model.Person;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

    public static final String FORM_VIEW = "form";
    public static final String RESULT_VIEW = "result";
    
    //Alternative 1
    @GetMapping("")
    public String redirect() {
    	return "redirect:/example3/showform";
    }
    
//    //Alternative 2
//    @GetMapping("")
//    public RedirectView redirectView() {
//    	return new RedirectView("/example3/showform");
//    }
    
    //Path: localhost:8081/example3/showform
    //Request the data and if you press the submit button redirects to 
    //"/addperson" resource and set the data there in a object person
    @GetMapping("/showform")
    public String showForm(Model model){
        model.addAttribute("person", new Person());
        return FORM_VIEW;
    }

    //Path: localhost:8081/example3/addperson
    //Receive the object person from the /showform resource and show it 
    //in the /addperson resource
    @PostMapping("/addperson")
    public ModelAndView addPerson(@ModelAttribute("person") Person person){
        ModelAndView mav = new ModelAndView(RESULT_VIEW);
        mav.addObject("person", person);
        return mav;
    }
}
