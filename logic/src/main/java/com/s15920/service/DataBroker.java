package com.s15920.service;

import com.s15920.HibernateUtil;
import com.s15920.model.*;
import org.hibernate.Session;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class DataBroker implements IDataBroker {

    private Session session;

    public DataBroker() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    private void commitAndCloseTransaction() {
        session.getTransaction().commit();
        session.close();
    }

    private void beginTransaction(){
        if (session == null) session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }


    @Override
    public int saveOrUpdate(Concert concert) {
        beginTransaction();
        int id = (Integer) session.save(concert);
        System.out.println(id);
        commitAndCloseTransaction();
        return id;
    }

    @Override
    public int saveOrUpdate(Ticket ticket) {
        beginTransaction();
        int id = (Integer) session.save(ticket);
        System.out.println(id);
        commitAndCloseTransaction();
        return id;
    }


    @Override
    public List<Ticket> getTicketsByConcertId(int id) {
        beginTransaction();

        System.out.println("Ticket service got concert id: "+id);
        String SQL = "FROM Ticket t ORDER BY t.title";

        @SuppressWarnings("unchecked")
        List<Ticket> tickets = (List<Ticket>) session.createQuery(
                SQL).list();

        for (Ticket t : tickets){
            System.out.println(t);
        }

        commitAndCloseTransaction();

        return tickets;
    }

    @Override
    public Person saveOrUpdate(String fn, String ln, String email, String mobile) {

        Person person = new Person();
        person.setFirstName(fn);
        person.setLastName(ln);
        person.setEmail(email);
        person.setMobile(mobile);
        person.setAddressId(1);
        person.setActive((byte) 1);
        person.setPassword("ew");
        person.setUsername("ew");
        person.setWhitelisted((byte) 1);

        beginTransaction();
        int id = (Integer) session.save(person);
        System.out.println(id);
        commitAndCloseTransaction();

        return person;
    }

    @Override
    public List<Concert> getAllConcerts() {
        beginTransaction();

        @SuppressWarnings("unchecked")
        List<Concert> concerts = (List<Concert>) session.createQuery(
                "FROM Concert c ORDER BY c.from ASC").list();

        commitAndCloseTransaction();

        return concerts;
    }

    @Override
    public List<Concert> getAllConcertsBetweenDates(Date from, Date to) {
        beginTransaction();

        @SuppressWarnings("unchecked")
        List<Concert> concerts = (List<Concert>) session.createQuery(
                "FROM Concert c WHERE c.from = from and c.to = to ORDER BY c.from ASC").list(); // FIXME

//        System.out.println(from);

        for (Concert c : concerts){
            System.out.println(c);
//            System.out.println(from.toString().equals(c.getFrom().toString()));
        }

        commitAndCloseTransaction();

        return concerts;
    }

    @Override
    public void saveOrUpdate(Person person, Byte ec, Byte pdc) {
        Purchase purchase = new Purchase();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
//        String date2 = dateFormat.format(date);
        purchase.setDate(new Date(date.getTime()));
        purchase.setEmailedReceipt(ec);
        purchase.setAmountPaid(0.0);
        purchase.setCardNumber("Not paid yet.");
        purchase.setCashierId(1);
        purchase.setPaymentMethod("Not provided yet.");
        purchase.setPersonId(person.getPersonId());
        purchase.setTicketId(0);
        purchase.setRefunded((byte) 0);
        beginTransaction();
        int id = (Integer) session.save(purchase);
        System.out.println(id);
        commitAndCloseTransaction();
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
        return null;
    }

    @Override
    public List<Person> getCustomerList() {
        return null;
    }

    @Override
    public List<Ticket> getAvailableTickets() {
        return null;
    }

    @Override
    public Concert getConcertById(int id) {
        return null;
    }

    @Override
    public void saveOrUpdate(Purchase purchase) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Purchase purchase) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void submitPurchase(Purchase purchase) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void issueRefund(Purchase purchase) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void saveOrUpdate(Manager manager) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Manager manager) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void hire(Person employee, double wage, double total, Employmenttype employmentType) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addEducation(String education) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void fire(Person employee) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void raiseWage(Person employee) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void promote(Person employee, String title) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void saveOrUpdate(Musician musician) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Musician musician) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Musician findMusicianById(Integer id) {
        return null;
    }

    @Override
    public void delete(Person person) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addRole(Person person, String role) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeRole(Person person, String role) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void switchRole(Person person, String role) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void checkIn() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void checkOut() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean GDPRremove(Person person) {
        return false;
    }

    @Override
    public boolean GDPRdownload(Person person) {
        return false;
    }

    @Override
    public void requestReceipt() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void switchWhiteBlackList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Purchase> getPurchasesByEmail(String email) {
        return null;
    }

    @Override
    public void emailReceipt() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void refund() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void printREceipt() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Ticket ticket) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void purchase() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void showDetails() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
