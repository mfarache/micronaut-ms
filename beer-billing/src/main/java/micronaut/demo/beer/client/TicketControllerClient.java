package micronaut.demo.beer.client;

import javax.validation.constraints.NotBlank;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.Client;
import io.reactivex.Single;
import micronaut.demo.beer.model.BeerItem;
import micronaut.demo.beer.model.Ticket;

@Client(id = "billing", path = "/billing")
public interface TicketControllerClient {

    @Get("/reset/{customerName}")
    HttpResponse resetCustomerBill(@NotBlank String customerName);

    @Post("/addBeer/{customerName}")
    HttpResponse<BeerItem> addBeerToCustomerBill(@Body BeerItem beer, @NotBlank String customerName);


    @Get("/bill/{customerName}")
    Single<Ticket> bill(@NotBlank String customerName);

    @Get("/cost/{customerName}")
    Single<Double> cost(@NotBlank String customerName);

}


