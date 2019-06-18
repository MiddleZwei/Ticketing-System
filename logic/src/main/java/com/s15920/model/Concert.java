package com.s15920.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Concert {
    private int concertId;
    private Date from;
    private Date to;
    private Double amount;
    private String title;

    @Id
    @Column(name = "concert_id", nullable = false)
    public int getConcertId() {
        return concertId;
    }

    public void setConcertId(int concertId) {
        this.concertId = concertId;
    }

    @Basic
    @Column(name = "from", nullable = true)
    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    @Basic
    @Column(name = "to", nullable = true)
    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Concert concert = (Concert) o;

        if (concertId != concert.concertId) return false;
        if (from != null ? !from.equals(concert.from) : concert.from != null) return false;
        if (to != null ? !to.equals(concert.to) : concert.to != null) return false;
        if (amount != null ? !amount.equals(concert.amount) : concert.amount != null) return false;
        if (title != null ? !title.equals(concert.title) : concert.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = concertId;
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Concert{" +
                "concertId=" + concertId +
                ", from=" + from +
                ", to=" + to +
                ", amount=" + amount +
                ", title='" + title + '\'' +
                '}';
    }
}
