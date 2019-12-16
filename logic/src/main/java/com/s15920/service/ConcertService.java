package com.s15920.service;

import com.s15920.model.Concert;
import com.s15920.model.Person;
import com.s15920.model.Purchase;
import com.s15920.model.Ticket;

import java.sql.Date;
import java.util.List;

public class ConcertService implements IConcertService{

    private IDataBroker db;


    public ConcertService() {
        this.db = new DataBroker();
    }

    /**
     * @param from
     * @param to
     * @return
     */
    @Override
    public List<Concert> getAllConcertsBetweenDates(Date from, Date to) {
        return db.getAllConcertsBetweenDates(from, to);
    }

    /**
     * @param concert
     */
    @Override
    public void saveOrUpdate(Concert concert) {
        db.saveOrUpdate(concert);
    }


    /**
     * @return
     */
    @Override
    public List<Concert> getAllConcerts() {
        return db.getAllConcerts();
    }

















    @Override
    public void delete(Concert concert) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setStartTime(Date startTime) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setEndTime(Date startTime) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Purchase> voidTicketsByConcertId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Person> getCustomerList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Ticket> getAvailableTickets() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Concert getConcertById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
