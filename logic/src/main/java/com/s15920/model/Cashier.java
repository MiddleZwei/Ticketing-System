package com.s15920.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cashier {
    private int cashierId;

    @Id
    @Column(name = "cashier_id", nullable = false)
    public int getCashierId() {
        return cashierId;
    }

    public void setCashierId(int cashierId) {
        this.cashierId = cashierId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cashier cashier = (Cashier) o;

        if (cashierId != cashier.cashierId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return cashierId;
    }
}
