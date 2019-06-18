package com.s15920.service;

import com.s15920.model.Concert;
import com.s15920.model.Purchase;

public interface ICashierService {
    void saveOrUpdate(Purchase purchase);
    void delete(Purchase purchase);

    void submitPurchase(Purchase purchase);
    void issueRefund(Purchase purchase);
}
