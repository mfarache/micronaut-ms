package micronaut.demo.beer.model;

public class BeerItem {
	private  String name;
	private  Size size;
	
	public enum Size {
		SMALL, MEDIUM, PINT, EMPTY;
	}

	public BeerItem() {

	}

	public String getName() {
		return name;
	}
	public Size getSize() {
		return size;
	}

	public BeerItem(String name, Size size) {
		super();
		this.name = name;
		this.size = size;
	}
	


}
