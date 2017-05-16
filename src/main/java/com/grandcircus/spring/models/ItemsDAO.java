package com.grandcircus.spring.models;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Created by Megan on 5/16/2017.
 */
public class ItemsDAO {

    public static ArrayList<ItemsEntity> deleteCustomerFromTable(@RequestParam("id") int id) {
        //temp CustomersEntity object will store info we want to delete
        ItemsEntity temp = new ItemsEntity();
        temp.setItemid(id);

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        Session selectCustomers = sessionFact.openSession();
        selectCustomers.beginTransaction();

        selectCustomers.delete(temp); //delete the object from the list
        selectCustomers.getTransaction().commit(); //delete the row from the db
        return ItemsDAO.getAllItems();
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

}
