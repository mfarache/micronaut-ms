package micronaut.demo.beer.function;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TicketBeerItem implements Serializable {
	private static final long serialVersionUID = -5803935122677992780L;
	private  String name;
    private  String size;

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    @JsonCreator
    public TicketBeerItem(@JsonProperty("name") String name, @JsonProperty("size") String size) {
        super();
        this.name = name;
        this.size = size;
    }
}