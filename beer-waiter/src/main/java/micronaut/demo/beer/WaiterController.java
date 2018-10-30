package micronaut.demo.beer;

import javax.validation.constraints.NotBlank;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.validation.Validated;
import io.reactivex.Single;
import micronaut.demo.beer.client.TicketControllerClient;
import micronaut.demo.beer.model.BeerItem;
import micronaut.demo.beer.model.Ticket;

@Controller("/waiter")
@Validated
public class WaiterController {

    TicketControllerClient ticketControllerClient;

    public WaiterController(TicketControllerClient ticketControllerClient) {
        this.ticketControllerClient = ticketControllerClient;
    }

    @Get("/beer/{customerName}")
    //@NewSpan
    public Single<Beer> serveBeerToCustomer(@NotBlank String customerName) {
        Beer beer = new Beer("mahou", Beer.Size.MEDIUM);
        BeerItem beerItem = new BeerItem(beer.getName(), BeerItem.Size.MEDIUM);
        ticketControllerClient.addBeerToCustomerBill(beerItem, customerName);
        return Single.just(beer);
    }
    
    @Get("/bill/{customerName}")
    //@NewSpan
    public Single<CustomerBill> bill(@NotBlank String customerName) {
        Single<Ticket> singleTicket = ticketControllerClient.bill(customerName);
        Single<Double> singleCost= ticketControllerClient.cost(customerName);
        Ticket ticket= singleTicket.blockingGet();
        CustomerBill bill = new CustomerBill(singleCost.blockingGet().doubleValue());
        bill.setDeskId(ticket.getDeskId());
        return Single.just(bill);
    }
}
