package danya.industries.infrastructure.config;

import org.reflections.Reflections;

/**
 * @author danya
 */

public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> ifc);

    Reflections getScanner();
}
