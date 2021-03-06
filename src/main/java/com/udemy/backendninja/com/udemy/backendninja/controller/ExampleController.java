package com.udemy.backendninja.com.udemy.backendninja.controller;

import com.udemy.backendninja.com.udemy.backendninja.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController {

    public static final String EXAMPLE_VIEW = "example";

    //Primera forma (sirve cuando solo hay q redireccionar o insertar pocos datos en las plantillas)
    @GetMapping("/exampleString")
    //@RequestMapping(value = "/exampleString", method = RequestMethod.GET)
    public String exampleString(Model model){
        model.addAttribute("person", new Person("Leo", 28));
        return EXAMPLE_VIEW;
    }

    //Segunda forma (sirve cuando hay q insertar muchos datos en las plantillas)
    @GetMapping("/exampleMAV")
    //@RequestMapping(value = "/exampleMAV", method = RequestMethod.GET)
    public ModelAndView exampleMAV(){
        ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
        mav.addObject("person", new Person("Enrique", 29));

        //return new ModelAndView(EXAMPLE_VIEW);
        return mav;
    }
}

