package com.s15920.service;

import com.s15920.model.Person;
import com.s15920.model.Purchase;

import java.util.List;

public class PurchaseService implements IPurchaseService {

    IDataBroker db;

    public PurchaseService(){
        this.db = new DataBroker();
    }

    /**
     * @param person
     * @param ec
     * @param pdc
     */
    @Override
    public void saveOrUpdate(Person person, Byte ec, Byte pdc) {
        db.saveOrUpdate(person, ec, pdc);
    }

    /**
     * @param purchase
     */
    @Override
    public void delete(Purchase purchase) {
        db.delete(purchase);
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
        db.emailReceipt();
    }

    /**
     *
     */
    @Override
    public void refund() {
        db.refund();
    }

    /**
     *
     */
    @Override
    public void printREceipt() {
        db.printREceipt();
    }
}
