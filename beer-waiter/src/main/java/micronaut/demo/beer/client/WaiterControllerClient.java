package micronaut.demo.beer.client;
import javax.validation.constraints.NotBlank;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.CircuitBreaker;
import io.reactivex.Single;
import micronaut.demo.beer.Beer;
import micronaut.demo.beer.CustomerBill;

@Client("/waiter")
@CircuitBreaker(delay = "1s", attempts = "5", multiplier = "3", reset = "100s")
public interface WaiterControllerClient {

    @Get("/beer/{customerName}")
    public Single<Beer> serveBeerToCustomer(@NotBlank String customerName);
    
    @Get("/bill/{customerName}")
    public Single<CustomerBill> bill(@NotBlank String customerName);
}
