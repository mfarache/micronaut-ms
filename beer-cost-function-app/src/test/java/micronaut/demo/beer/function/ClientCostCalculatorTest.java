package micronaut.demo.beer.function;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.server.EmbeddedServer;

public class ClientCostCalculatorTest {
	
	@Test
	public void testBeerCost() throws Exception {
        EmbeddedServer server = ApplicationContext.run(EmbeddedServer.class);
        ClientCostCalculator client = server.getApplicationContext().getBean(ClientCostCalculator.class);
        TicketBeerItem beer1 = new TicketBeerItem("MAHOU", "S");
        TicketCostRequest request = new TicketCostRequest(Arrays.asList(beer1));
        TicketCostResponse responseCost = client.apply(request).blockingGet();
        assertEquals(1.5, responseCost.getCost(),0);
        server.stop();
    }
}
