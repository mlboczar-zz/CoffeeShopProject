package com.grandcircus.spring.controller;

import com.grandcircus.spring.Customer;
import com.grandcircus.spring.JDBCCommands;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.*;

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
                ModelAndView("registration","customer",new Customer());
    }

    @RequestMapping(value= "/addCustomer", method = RequestMethod.POST)
    public String addCustomer(Customer customer, Model model) throws SQLException, ClassNotFoundException {
        model.addAttribute("customer", customer);
        JDBCCommands.formToDatabase(customer);
        return "summary";
    }

    @ModelAttribute("command")
    public Customer defaultInstance(){
        return new Customer();
    }

}
