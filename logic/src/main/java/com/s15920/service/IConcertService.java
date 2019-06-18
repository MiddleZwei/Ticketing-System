package com.s15920.service;

import com.s15920.model.Concert;
import com.s15920.model.Person;
import com.s15920.model.Purchase;
import com.s15920.model.Ticket;

import java.sql.Date;
import java.util.List;

public interface IConcertService {
    void saveOrUpdate(Concert concert);
    void delete(Concert concert);

    void setStartTime(Date startTime);
    void setEndTime(Date startTime);
    List<Concert> getAllConcerts();
    List<Purchase> voidTicketsByConcertId(Integer id);
    List<Person> getCustomerList();
    List<Ticket> getAvailableTickets();
    Concert getConcertById(int id);
    List<Concert> getAllConcertsBetweenDates(Date from, Date to);


}
