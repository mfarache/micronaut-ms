package micronaut.demo.beer.service;

import micronaut.demo.beer.model.Ticket;

public interface BillService {

    Ticket getBillForCostumer(String username) ;
    void  createBillForCostumer(String username, Ticket ticket) ;
    String usersInBarMessage() ;

}
