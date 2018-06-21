package micronaut.demo.beer;

public class BeerItem {
	private  String name;
	private  Size size;
	
	public enum Size {
		SMALL, MEDIUM, PINT;
	}
	public String getName() {
		return name;
	}
	public Size getSize() {
		return size;
	}
	
	public BeerItem() {
		
	}
	
	public BeerItem(String name, Size size) {
		super();
		this.name = name;
		this.size = size;
	}
	
	public double getCost() {
		switch (size) {
			case SMALL : return 10;
			case MEDIUM : return 12;
			case PINT: return 15;
			default: return 0;
		}
	}
}
