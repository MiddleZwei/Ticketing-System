package com.s15920;

import com.s15920.model.Concert;
import com.s15920.service.DataBroker;

import java.sql.Date;
import java.util.List;


/**
 * Class used to perform CRUD operation on database with Hibernate API's
 *
 */
public class App {

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        App application = new App();

        java.util.Date uDate = new java.util.Date();
//        java.sql.Date sDate = new java.sql.Date(uDate.getTime());

//        Concert concert1 = new Concert();
        int concert1_id = application.createConcert(new Date(uDate.getTime()), new Date(uDate.getTime()), 1.3, "Concert1");

        listAllConcerts();

        List<Concert> allConcerts = App.listAllConcerts();
        System.out.println("List of all remained persisted concerts >>>");
        for (Concert concert : allConcerts) {
            System.out.println("Persisted Concert :" + concert);
        }



    }

    private int createConcert(Date from, Date to, double amount, String title) {
        Concert c = new Concert();
        c.setAmount(amount);
        c.setFrom(from);
        c.setTo(to);
        c.setTitle(title);

        DataBroker db = new DataBroker();
        return db.saveOrUpdate(c);
    }

    private static List<Concert> listAllConcerts() {
        DataBroker db = new DataBroker();
        return db.getAllConcerts();
    }


}