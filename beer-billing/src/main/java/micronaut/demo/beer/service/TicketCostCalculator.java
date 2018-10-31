package micronaut.demo.beer.service;

import micronaut.demo.beer.model.Ticket;

public interface TicketCostCalculator {
    public double calculateCost(Ticket ticket) ;
}
