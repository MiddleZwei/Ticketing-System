package com.s15920.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Ticket {
    private int ticketId;
    private Date validFrom;
    private Date validTo;
    private Double amount;
    private String title;
    private String concertId;

    @Id
    @Column(name = "ticket_id", nullable = false)
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    @Basic
    @Column(name = "validFrom", nullable = true)
    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    @Basic
    @Column(name = "validTo", nullable = true)
    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    @Basic
    @Column(name = "amount", nullable = true, precision = 0)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 30)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "concert_id", nullable = true)
    public String getConcertId() {
        return concertId;
    }

    public void setConcertId(String concertId) {
        this.concertId = concertId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (ticketId != ticket.ticketId) return false;
        if (validFrom != null ? !validFrom.equals(ticket.validFrom) : ticket.validFrom != null) return false;
        if (validTo != null ? !validTo.equals(ticket.validTo) : ticket.validTo != null) return false;
        if (amount != null ? !amount.equals(ticket.amount) : ticket.amount != null) return false;
        if (title != null ? !title.equals(ticket.title) : ticket.title != null) return false;
        if (concertId != null ? !concertId.equals(ticket.concertId) : ticket.concertId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ticketId;
        result = 31 * result + (validFrom != null ? validFrom.hashCode() : 0);
        result = 31 * result + (validTo != null ? validTo.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (concertId != null ? concertId.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                ", amount=" + amount +
                ", title='" + title + '\'' +
                ", concertId=" + concertId +
                '}';
    }
}
