package micronaut.demo.beer;

public class CustomerBill {
	private  double cost;
	private int deskId;

	public int getDeskId() {
		return deskId;
	}

	public void setDeskId(int deskId) {
		this.deskId = deskId;
	}


	public double getCost() {
		return cost;
	}

	public CustomerBill() {
		this(0);
	}

	public CustomerBill(double cost) {
		super();
		this.cost = cost;
	}
}
