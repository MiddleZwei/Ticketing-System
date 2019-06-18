package com.s15920.service;

import com.s15920.model.Person;
import com.s15920.model.Purchase;

import java.util.List;

public interface IPurchaseService {

    void saveOrUpdate(Person person, Byte ec, Byte pdc);
    void delete(Purchase purchase);

    List<Purchase> getPurchasesByEmail(String email);
    void emailReceipt();
    void refund();
    void printREceipt();
}
