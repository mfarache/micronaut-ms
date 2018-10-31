package micronaut.demo.beer.function;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TicketCostRequest implements Serializable {

	private static final long serialVersionUID = -3999476323141649992L;
	private List<TicketBeerItem> beerItems = new ArrayList<>();

    @JsonCreator
    public TicketCostRequest(@JsonProperty("beerItems") List<TicketBeerItem> beerItems) {
        this.beerItems = beerItems;
    }

    public List<TicketBeerItem> getBeerItems() {
        return beerItems;
    }
}
