package com.s15920.service;

import com.s15920.HibernateUtil;
import com.s15920.model.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Queue;

/**
 *
 */
public class DataBroker implements IDataBroker {

    private Session session;

    public DataBroker() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    private void commitAndCloseTransaction() {
        try {
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void beginTransaction(){
        if (session == null) session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * @param concert
     * @return
     */
    @Override
    public int saveOrUpdate(Concert concert) {
        beginTransaction();
        int id = (Integer) session.save(concert);
        System.out.println(id);
        commitAndCloseTransaction();
        return id;
    }

    /**
     * @param ticket
     * @return
     */
    @Override
    public int saveOrUpdate(Ticket ticket) {
        beginTransaction();
        int id = (Integer) session.save(ticket);
        System.out.println(id);
        commitAndCloseTransaction();
        return id;
    }


    /**
     * @param id
     * @return
     */
    @Override
    public List<Ticket> getTicketsByConcertId(Integer id) {
        beginTransaction();

        System.out.println("------------------");
        System.out.println("DataBroker got concert id: "+id);
        String SQL = "FROM Ticket t ORDER BY t.title";
        Query query = session.createQuery(SQL);
//        query.setParameter("id", '3');

        @SuppressWarnings("unchecked")
        List<Ticket> tickets = (List<Ticket>) query.list();

        for (Ticket t : tickets){
            System.out.println(t);
        }

        commitAndCloseTransaction();

        return tickets;
    }

    /**
     * @param fn
     * @param ln
     * @param email
     * @param mobile
     * @return
     */
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

    /**
     * @return
     */
    @Override
    public List<Concert> getAllConcerts() {
        beginTransaction();

        @SuppressWarnings("unchecked")
        List<Concert> concerts = (List<Concert>) session.createQuery(
                "FROM Concert c ORDER BY c.from ASC").list();

        commitAndCloseTransaction();

        return concerts;
    }


    /**
     * @param f
     * @param t
     * @return
     */
    @Override
    public List<Concert> getAllConcertsBetweenDates(Date f, Date t) {
        beginTransaction();

        System.out.println("------------------");
        System.out.println("Query got from date: " + f.toString());
        System.out.println("Query got to date: " + t.toString());

        String SQL = "FROM Concert c WHERE c.from>=:f or c.to<=:t ORDER BY c.from ASC";
        Query query = session.createQuery(SQL);
        query.setParameter("f", f);
        query.setParameter("t", t);
        System.out.println("SQL query: "+ query.getQueryString());

        System.out.println("------------------");

        @SuppressWarnings("unchecked")
        List<Concert> concerts = (List<Concert>) query.list();

        // WHERE c.from >= from and c.to <= to

        for (Concert c : concerts){
            System.out.println(c);
        }

        commitAndCloseTransaction();

        return concerts;
    }

    /**
     * @param person
     * @param ec
     * @param pdc
     */
    @Override
    public void saveOrUpdate(Person person, Byte ec, Byte pdc) {
        Purchase purchase = new Purchase();
//        Person pdb = findPersonById(person.getPersonId());
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
        purchase.setTicketId(1);
        purchase.setRefunded((byte) 0);

        beginTransaction();
        int id = saveInSession(purchase);
        System.out.println(id);
        commitAndCloseTransaction();
    }

    /**
     * @param purchase
     * @return
     */
    private int saveInSession(Purchase purchase) {
        int id;
        try {
            id = (Integer) session.save(purchase);
            return id;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }

    /**
     * @param personId
     * @return
     */
    @Override
    public Person findPersonById(int personId) {
        beginTransaction();

        System.out.println("------------------");
        System.out.println("DataBroker got person id: "+personId);

        String SQL = "FROM Person t";
        Query query = session.createQuery(SQL);

        @SuppressWarnings("unchecked")
        List<Person> persons = (List<Person>) query.list();

        for (Person p : persons){
            if (p.getPersonId() == personId){
                System.out.println("Found person with id "+personId);
                return p;
            }
        }

        commitAndCloseTransaction();

        return null;
    }


    /**
     * @param concert
     */
    @Override
    public void delete(Concert concert) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param startTime
     */
    @Override
    public void setStartTime(Date startTime) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param startTime
     */
    @Override
    public void setEndTime(Date startTime) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<Purchase> voidTicketsByConcertId(Integer id) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<Person> getCustomerList() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<Ticket> getAvailableTickets() {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Concert getConcertById(int id) {
        return null;
    }

    /**
     * @param purchase
     */
    @Override
    public void saveOrUpdate(Purchase purchase) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param purchase
     */
    @Override
    public void delete(Purchase purchase) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param purchase
     */
    @Override
    public void submitPurchase(Purchase purchase) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param purchase
     */
    @Override
    public void issueRefund(Purchase purchase) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param manager
     */
    @Override
    public void saveOrUpdate(Manager manager) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param manager
     */
    @Override
    public void delete(Manager manager) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param employee
     * @param wage
     * @param total
     * @param employmentType
     */
    @Override
    public void hire(Person employee, double wage, double total, Employmenttype employmentType) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param education
     */
    @Override
    public void addEducation(String education) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param employee
     */
    @Override
    public void fire(Person employee) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param employee
     */
    @Override
    public void raiseWage(Person employee) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param employee
     * @param title
     */
    @Override
    public void promote(Person employee, String title) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param musician
     */
    @Override
    public void saveOrUpdate(Musician musician) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param musician
     */
    @Override
    public void delete(Musician musician) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Musician findMusicianById(Integer id) {
        return null;
    }

    /**
     * @param person
     */
    @Override
    public void delete(Person person) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param person
     * @param role
     */
    @Override
    public void addRole(Person person, String role) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param person
     * @param role
     */
    @Override
    public void removeRole(Person person, String role) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param person
     * @param role
     */
    @Override
    public void switchRole(Person person, String role) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     */
    @Override
    public void checkIn() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     */
    @Override
    public void checkOut() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param person
     * @return
     */
    @Override
    public boolean GDPRremove(Person person) {
        return false;
    }

    /**
     * @param person
     * @return
     */
    @Override
    public boolean GDPRdownload(Person person) {
        return false;
    }

    /**
     *
     */
    @Override
    public void requestReceipt() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     */
    @Override
    public void switchWhiteBlackList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param email
     * @return
     */
    @Override
    public List<Purchase> getPurchasesByEmail(String email) {
        return null;
    }

    /**
     *
     */
    @Override
    public void emailReceipt() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     */
    @Override
    public void refund() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     */
    @Override
    public void printREceipt() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param ticket
     */
    @Override
    public void delete(Ticket ticket) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     */
    @Override
    public void purchase() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     */
    @Override
    public void showDetails() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
