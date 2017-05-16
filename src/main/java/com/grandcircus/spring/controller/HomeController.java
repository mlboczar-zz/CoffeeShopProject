package com.grandcircus.spring.controller;

import com.grandcircus.spring.Customer;
import com.grandcircus.spring.JDBCCommands;
import com.grandcircus.spring.models.ItemsEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Megan on 5/8/2017.
 */

@Controller
public class HomeController {

    @RequestMapping(value="/")
    public String index(Model model) {
        JDBCCommands.displayItems(model);
        return "index";
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

    @RequestMapping("itemadmin")
    public ModelAndView itemAdmin() {
        ArrayList<ItemsEntity> itemsList = HomeController.getAllItems();
        return new
                ModelAndView("itemadmin", "itemsList", itemsList);
    }

    @ModelAttribute("command")
    public Customer defaultInstance(){
        return new Customer();
    }

    //This is a regular method that was extracted for repeated use
    //this defines the configuration and mapping resources
    public static ArrayList<ItemsEntity> getAllItems() {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        Session selectCustomers = sessionFact.openSession();
        selectCustomers.beginTransaction();
        Criteria c = selectCustomers.createCriteria(ItemsEntity.class);
        return (ArrayList<ItemsEntity>) c.list();
    }






    @RequestMapping("delete")
    public ModelAndView deleteCustomer(@RequestParam("id") int id) {

        //temp CustomersEntity object will store info we want to delete
        ItemsEntity temp = new ItemsEntity();
        temp.setItemid(id);

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        Session selectCustomers = sessionFact.openSession();
        selectCustomers.beginTransaction();

        selectCustomers.delete(temp); //delete the object from the list
        selectCustomers.getTransaction().commit(); //delete the row from the db
        ArrayList<ItemsEntity> itemsList = getAllItems();

        return new ModelAndView("itemadmin", "itemsList", itemsList);
    }
}
