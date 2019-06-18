package com.s15920.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Purchase {
    private int purchaseId;
    private Date date;
    private String paymentMethod;
    private String cardNumber;
    private byte emailedReceipt;
    private Double amountPaid;
    private byte refunded;
    private Integer cashierId;
    private Integer ticketId;
    private Integer personId;

    @Id
    @Column(name = "purchase_id", nullable = false)
    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "payment_method", nullable = true, length = 30)
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Basic
    @Column(name = "card_number", nullable = true, length = 16)
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Basic
    @Column(name = "emailed_receipt", nullable = false)
    public byte getEmailedReceipt() {
        return emailedReceipt;
    }

    public void setEmailedReceipt(byte emailedReceipt) {
        this.emailedReceipt = emailedReceipt;
    }

    @Basic
    @Column(name = "amount_paid", nullable = true, precision = 0)
    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    @Basic
    @Column(name = "refunded", nullable = false)
    public byte getRefunded() {
        return refunded;
    }

    public void setRefunded(byte refunded) {
        this.refunded = refunded;
    }

    @Basic
    @Column(name = "cashier_id", nullable = true)
    public Integer getCashierId() {
        return cashierId;
    }

    public void setCashierId(Integer cashierId) {
        this.cashierId = cashierId;
    }

    @Basic
    @Column(name = "ticket_id", nullable = true)
    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    @Basic
    @Column(name = "person_id", nullable = true)
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        if (purchaseId != purchase.purchaseId) return false;
        if (emailedReceipt != purchase.emailedReceipt) return false;
        if (refunded != purchase.refunded) return false;
        if (date != null ? !date.equals(purchase.date) : purchase.date != null) return false;
        if (paymentMethod != null ? !paymentMethod.equals(purchase.paymentMethod) : purchase.paymentMethod != null)
            return false;
        if (cardNumber != null ? !cardNumber.equals(purchase.cardNumber) : purchase.cardNumber != null) return false;
        if (amountPaid != null ? !amountPaid.equals(purchase.amountPaid) : purchase.amountPaid != null) return false;
        if (cashierId != null ? !cashierId.equals(purchase.cashierId) : purchase.cashierId != null) return false;
        if (ticketId != null ? !ticketId.equals(purchase.ticketId) : purchase.ticketId != null) return false;
        if (personId != null ? !personId.equals(purchase.personId) : purchase.personId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = purchaseId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (paymentMethod != null ? paymentMethod.hashCode() : 0);
        result = 31 * result + (cardNumber != null ? cardNumber.hashCode() : 0);
        result = 31 * result + (int) emailedReceipt;
        result = 31 * result + (amountPaid != null ? amountPaid.hashCode() : 0);
        result = 31 * result + (int) refunded;
        result = 31 * result + (cashierId != null ? cashierId.hashCode() : 0);
        result = 31 * result + (ticketId != null ? ticketId.hashCode() : 0);
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        return result;
    }
}
