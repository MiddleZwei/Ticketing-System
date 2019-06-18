package com.s15920.service;

import com.s15920.model.Person;

public interface IPersonService {
    Person saveOrUpdate(String fn, String ln, String email, String mobile);
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
}
