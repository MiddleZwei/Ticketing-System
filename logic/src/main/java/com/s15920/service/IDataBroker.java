package com.s15920.service;

import com.s15920.model.*;

import java.sql.Date;
import java.util.List;

interface IDataBroker {


    // concert
    int saveOrUpdate(Concert concert);

    Person findPersonById(int personId);

    void delete(Concert concert);
    void setStartTime(Date startTime);
    void setEndTime(Date startTime);
    List<Concert> getAllConcerts();
    List<Purchase> voidTicketsByConcertId(Integer id);
    List<Person> getCustomerList();
    List<Ticket> getAvailableTickets();
    Concert getConcertById(int id);
    List<Concert> getAllConcertsBetweenDates(Date from, Date to);

    // cashier
    void saveOrUpdate(Purchase purchase);
    void delete(Purchase purchase);
    void submitPurchase(Purchase purchase);
    void issueRefund(Purchase purchase);

    // manager
    void saveOrUpdate(Manager manager);
    void delete(Manager manager);
    void hire(Person employee, double wage, double total, Employmenttype employmentType);
    void addEducation(String education);
    void fire(Person employee);
    void raiseWage(Person employee);
    void promote(Person employee, String title);

    // musician
    void saveOrUpdate(Musician musician);
    void delete(Musician musician);
    Musician findMusicianById(Integer id);
    // void addSong(Song song);

    // person
    void saveOrUpdate(Person person, Byte ec, Byte pdc);
    void delete(Person person);
    void addRole(Person person, String role);
    void removeRole(Person person, String role);
    void switchRole(Person person, String role);
    void checkIn();
    void checkOut();
    boolean GDPRremove(Person person);
    boolean GDPRdownload(Person person);
    void requestReceipt();
    void switchWhiteBlackList();

    // purchase
    // like in casier
    // void saveOrUpdate(Purchase purchase);
    // void delete(Purchase purchase);
    List<Purchase> getPurchasesByEmail(String email);
    void emailReceipt();
    void refund();
    void printREceipt();

    // ticket
    int saveOrUpdate(Ticket ticket);
    void delete(Ticket ticket);
    void purchase();
    void showDetails();
    List<Ticket> getTicketsByConcertId(Integer id);


    Person saveOrUpdate(String fn, String ln, String email, String mobile);
}
