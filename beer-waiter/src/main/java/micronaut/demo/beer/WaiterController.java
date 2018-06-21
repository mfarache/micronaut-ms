package micronaut.demo.beer;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.validation.Validated;
import io.reactivex.Single;
import micronaut.demo.beer.client.TicketControllerClient;

import javax.validation.constraints.NotBlank;

@Controller("/waiter")
@Validated
public class WaiterController {

    TicketControllerClient ticketControllerClient;

    public WaiterController(TicketControllerClient ticketControllerClient) {
        this.ticketControllerClient = ticketControllerClient;
    }

    @Get("/beer/{customerName}")
    public Single<Beer> serveBeerToCustomer(@NotBlank String customerName) {
        return Single.just(new Beer("mahou", Beer.Size.MEDIUM));
    }
    
    @Get("/bill/{customerName}")
    public Single<CustomerBill> bill(@NotBlank String customerName) {
        Single<Ticket> singleTicket = ticketControllerClient.bill(customerName);
        Ticket ticket= singleTicket.blockingGet();
        CustomerBill bill = new CustomerBill(ticket.getCost());
        bill.setDeskId(ticket.getDeskId());
        return Single.just(bill);
    }
}
