package micronaut.demo.beer.service;

import micronaut.demo.beer.model.Ticket;

public interface CostCalculator {
    public double calculateCost(Ticket ticket) ;
}
