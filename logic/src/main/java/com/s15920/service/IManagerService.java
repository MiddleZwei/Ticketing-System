package com.s15920.service;

import com.s15920.model.Employmenttype;
import com.s15920.model.Manager;
import com.s15920.model.Person;
import com.s15920.model.Purchase;

public interface IManagerService {
    void saveOrUpdate(Manager manager);
    void delete(Manager manager);

    void hire(Person employee, double wage, double total, Employmenttype employmentType);
    void addEducation(String education);
    void fire(Person employee);
    void raiseWage(Person employee);
    void promote(Person employee, String title);
}
