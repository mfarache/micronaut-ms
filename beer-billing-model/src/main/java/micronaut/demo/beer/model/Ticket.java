package micronaut.demo.beer.model;

import java.util.ArrayList;
import java.util.List;

public class Ticket {

	private int deskId;
	private  double cost = 0;
	private List<BeerItem> beerItems = new ArrayList<>();

	public Ticket() {
		cost = 0;
	}

	public List<BeerItem> getBeerItems() {
		return beerItems;
	}

	public void setBeerItems(List<BeerItem> beerItems) {
		this.beerItems = beerItems;
	}

	public int getDeskId() {
		return deskId;
	}

	public void setDeskId(int deskId) {
		this.deskId = deskId;
	}


	public void add(BeerItem beer) {
		beerItems.add(beer);
	}

}
