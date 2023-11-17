package danya.industries.infrastructure;

import danya.industries.infrastructure.config.impl.JavaConfig;
import danya.industries.infrastructure.factory.ObjectFactory;

import java.util.Map;

/**
 * Application is initialization point for our infrastructure.
 * @author danya
 */

public class Application {
    public static ApplicationContext run(String packageToScan, Map<Class<?>, Class<?>> ifc2ImplClass) {
        JavaConfig config = new JavaConfig(packageToScan, ifc2ImplClass);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory objectFactory = new ObjectFactory(context);
        context.setFactory(objectFactory);
        return context;
    }
}
