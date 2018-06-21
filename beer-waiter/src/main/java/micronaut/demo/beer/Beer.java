package micronaut.demo.beer;

public class Beer {
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
	
	public Beer() {
		
	}
	
	public Beer(String name, Size size) {
		super();
		this.name = name;
		this.size = size;
	}
}
