package micronaut.demo.beer;

import java.util.HashMap;
import java.util.Optional;

import javax.validation.constraints.NotBlank;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.validation.Validated;
import io.reactivex.Single;

@Controller("/billing")
@Validated
public class TicketController {


	final EmbeddedServer embeddedServer;

	public TicketController(EmbeddedServer embeddedServer) {
		this.embeddedServer = embeddedServer;
	}
	
	HashMap<String, Ticket> billsPerCustomer = new HashMap<>();
	
	@Get("/reset/{customerName}")
    public HttpResponse resetCustomerBill(@NotBlank String customerName) {
    	    billsPerCustomer.put(customerName, new Ticket());
    	    return HttpResponse.ok();
    }

    @Post("/addBeer/{customerName}")
    public HttpResponse<BeerItem> addBeerToCustomerBill(@Body BeerItem beer, @NotBlank String customerName) {
    	    Optional<Ticket> t = Optional.ofNullable(billsPerCustomer.get(customerName));
    	    Ticket ticket = t.isPresent() ?  t.get() : new Ticket();
    	    ticket.add(beer);
    	    billsPerCustomer.put(customerName, ticket);
    	    return HttpResponse.ok(beer);
    }
    
    @Get("/bill/{customerName}")
    public Single<Ticket> bill(@NotBlank String customerName) {
    		Optional<Ticket> t = Optional.ofNullable(billsPerCustomer.get(customerName));
    		Ticket ticket = t.isPresent() ?  t.get() : new Ticket();
    		ticket.setDeskId(embeddedServer.getPort());
        return Single.just(ticket);
    }
}
