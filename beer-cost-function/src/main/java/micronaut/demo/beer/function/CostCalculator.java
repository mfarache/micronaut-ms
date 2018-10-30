package micronaut.demo.beer.function;

import java.util.HashMap;
import java.util.Map;
import java.util.function.*;
import io.micronaut.function.FunctionBean;

@FunctionBean("beer-cost")
public class CostCalculator implements  Function<TicketCostRequest, TicketCostResponse>{

    private static final double SMALL_FACTOR=1;
    private static final double PINT_FACTOR=1.8;

    private static final Map<String, Double> beerCost = new HashMap<String, Double>();
    static {
        beerCost.put("MAHOU", 1.5);
        beerCost.put("HEINEKEN", 2.0);
        beerCost.put("FRANCISKANER", 2.5);
        beerCost.put("PAULANER", 2.8);
    }

    @Override
    public TicketCostResponse apply(TicketCostRequest ticketCostRequest) {
        return new TicketCostResponse( allBeersCost(ticketCostRequest));
    }

    private double allBeersCost(TicketCostRequest ticketCostRequest) {
        return ticketCostRequest
                .getBeerItems()
                .stream()
                .map( beer ->  calculateBeerCost(beer))
                .mapToDouble(i->i).sum();
    }

    private double calculateBeerCost(TicketBeerItem beer) {
        switch (beer.getSize()) {
            case "S" : return SMALL_FACTOR* beerCost.get(beer.getName());
            case "P":  return PINT_FACTOR* beerCost.get(beer.getName());
            default: return 0;
        }
    }
}