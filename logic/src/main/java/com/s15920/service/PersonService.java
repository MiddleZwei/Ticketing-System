package com.s15920.service;

import com.s15920.model.Person;

public class PersonService implements IPersonService {

    IDataBroker db;

    public PersonService() {
        this.db = new DataBroker();
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
        return db.saveOrUpdate(fn, ln, email, mobile);
    }

    /**
     * @param person
     */
    @Override
    public void delete(Person person) {
        db.delete(person);
    }

    /**
     * @param person
     * @param role
     */
    @Override
    public void addRole(Person person, String role) {
        db.addRole(person, role);
    }

    /**
     * @param person
     * @param role
     */
    @Override
    public void removeRole(Person person, String role) {
        db.removeRole(person, role);
    }

    /**
     * @param person
     * @param role
     */
    @Override
    public void switchRole(Person person, String role) {
        db.switchRole(person, role);
    }

    /**
     *
     */
    @Override
    public void checkIn() {
        db.checkIn();
    }

    /**
     *
     */
    @Override
    public void checkOut() {
        db.checkOut();
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
        db.requestReceipt();
    }

    /**
     *
     */
    @Override
    public void switchWhiteBlackList() {
        db.switchWhiteBlackList();
    }
}
