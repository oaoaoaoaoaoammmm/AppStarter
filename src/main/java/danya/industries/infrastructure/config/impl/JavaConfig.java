package danya.industries.infrastructure.config.impl;

import danya.industries.infrastructure.config.Config;
import lombok.Getter;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

/**
 * JavaConfig store all our implementation of interfaces.
 *
 * @author danya
 */

public class JavaConfig implements Config {

    @Getter
    private Reflections scanner;

    //TODO map stores the required impl if we have 2 impl then exception throws but if map knows the required impl then it returns this impl
    private final Map<Class<?>, Class<?>> ifc2ImplClass;

    public JavaConfig(String packageToScan, Map<Class<?>, Class<?>> ifc2ImplClass) {
        this.ifc2ImplClass = ifc2ImplClass;
        this.scanner = new Reflections(packageToScan);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
        return (Class<? extends T>) ifc2ImplClass.computeIfAbsent(ifc, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
            if (classes.size() != 1) {
                throw new RuntimeException(ifc + " has 0 or more than one impl please update your config");
            }
            return classes.iterator().next();
        });
    }
}












