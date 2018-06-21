package micronaut.demo.beer;


import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.server.EmbeddedServer;
import io.reactivex.Single;

import micronaut.demo.beer.client.WaiterControllerClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WaiterControllerTest {

    private final String USERNAME="mauricio";
    private final String BEER_NAME="mahou";

    private EmbeddedServer server;
    private WaiterControllerClient client;

    @Before
    public void setup() {
        this.server = ApplicationContext.run(EmbeddedServer.class);
        this.client = server.getApplicationContext().getBean(WaiterControllerClient.class);
    }

    @Test
    public void shouldReturnHello() {
        Beer response = client.serveBeerToCustomer(USERNAME).blockingGet();
        assertEquals(response.getName(), BEER_NAME);
    }

    @Test
    public void shouldReturnBillForCustomer() {
        Single<CustomerBill> response = client.bill(USERNAME);
        assertEquals(response.blockingGet().getCost(), 0, 0);
    }

    @After
    public void cleanup() {
        this.server.stop();
    }
}