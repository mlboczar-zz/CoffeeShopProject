package com.grandcircus.spring.controller;

import com.grandcircus.spring.CoffeeCustomer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Megan on 5/8/2017.
 */

@Controller
public class HomeController {

    @RequestMapping(value="/")
    public ModelAndView index() {
        return new
                ModelAndView("index", "", "");
    }

    @RequestMapping(value="/registration")
    public ModelAndView customer()
    {
        return new
                ModelAndView("registration","customer",new CoffeeCustomer());
    }

    @RequestMapping(value="/addCoffeeCustomer", method = RequestMethod.POST)
    public String addCustomer(CoffeeCustomer coffeeCustomer, Model model){
        model.addAttribute("customer",coffeeCustomer);

        return "summary";
    }

    @ModelAttribute("command")
    public CoffeeCustomer defaultInstance(){
        return new CoffeeCustomer();
    }
}
