package com.s15920.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Seat {
    private int seatId;
    private Integer row;
    private Integer number;
    private Integer ticketId;

    @Id
    @Column(name = "seat_id", nullable = false)
    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    @Basic
    @Column(name = "row", nullable = true)
    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    @Basic
    @Column(name = "number", nullable = true)
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Basic
    @Column(name = "ticket_id", nullable = true)
    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seat seat = (Seat) o;

        if (seatId != seat.seatId) return false;
        if (row != null ? !row.equals(seat.row) : seat.row != null) return false;
        if (number != null ? !number.equals(seat.number) : seat.number != null) return false;
        if (ticketId != null ? !ticketId.equals(seat.ticketId) : seat.ticketId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = seatId;
        result = 31 * result + (row != null ? row.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (ticketId != null ? ticketId.hashCode() : 0);
        return result;
    }
}
