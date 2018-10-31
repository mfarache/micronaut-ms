package micronaut.demo.beer.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.micronaut.context.annotation.Primary;
import micronaut.demo.beer.function.ClientCostCalculator;
import micronaut.demo.beer.function.TicketBeerItem;
import micronaut.demo.beer.function.TicketCostRequest;
import micronaut.demo.beer.model.BeerItem;
import micronaut.demo.beer.model.BeerItem.Size;
import micronaut.demo.beer.model.Ticket;

@Primary
public class RemoteFunctionBeerCostCalculator implements TicketCostCalculator {
	
	private  ClientCostCalculator client;
	
	@Inject
	public  RemoteFunctionBeerCostCalculator (ClientCostCalculator client) {
		this.client = client;
	}

	public double calculateCost(Ticket ticket) {
		
		List<TicketBeerItem> beerItems = new ArrayList<>();
		ticket.getBeerItems().forEach(beerItem->beerItems.add(map(beerItem)));
		
		TicketCostRequest ticketCostRequest = new TicketCostRequest(beerItems);
		return client.apply(ticketCostRequest).blockingGet().getCost();
	}

	private TicketBeerItem map(BeerItem beerItem) {
		return new TicketBeerItem(beerItem.getName(), map(beerItem.getSize()));
	}

	private String map(Size size) {
		if (size.equals(Size.SMALL)) {
			return "S";
		} else {
			return "P";
		}
	}
}
