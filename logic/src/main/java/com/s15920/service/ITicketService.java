package com.s15920.service;


import com.s15920.model.Ticket;

import java.util.List;

public interface ITicketService {
    void saveOrUpdate(Ticket ticket);
    void delete(Ticket ticket);
    void purchase();
    void showDetails();
    List<Ticket> getTicketsByConcertId(int id);
}
