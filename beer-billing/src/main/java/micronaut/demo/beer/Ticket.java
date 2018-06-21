package micronaut.demo.beer;

import java.util.ArrayList;
import java.util.List;

public class Ticket {

	private int deskId;
	private  double cost = 0;
	private List<BeerItem> items = new ArrayList<>();

	public Ticket() {
		cost = 0;
	}


	public int getDeskId() {
		return deskId;
	}

	public void setDeskId(int deskId) {
		this.deskId = deskId;
	}

	public double getCost() {
		items.stream().forEach( beer -> cost += beer.getCost());
		return cost;
	}

	public void add(BeerItem beer) {
		items.add(beer);
	}

}
