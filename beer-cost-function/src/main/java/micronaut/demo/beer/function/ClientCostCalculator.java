package micronaut.demo.beer.function;

import javax.inject.Named;

import io.micronaut.function.client.FunctionClient;
import io.micronaut.http.annotation.Body;
import io.reactivex.Single;

@FunctionClient
public interface ClientCostCalculator {
	 @Named("beer-cost")
	 public Single<TicketCostResponse> apply(@Body TicketCostRequest ticketCostRequest) ;
}
