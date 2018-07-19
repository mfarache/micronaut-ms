package micronaut.demo.beer;

import io.micronaut.context.ApplicationContext;
import io.micronaut.context.DefaultApplicationContextBuilder;
import io.micronaut.context.env.PropertySource;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.runtime.Micronaut;

public class BillingApplication {

    public static void main(String[] args) {

         Micronaut.run(BillingApplication.class);
    }
}
