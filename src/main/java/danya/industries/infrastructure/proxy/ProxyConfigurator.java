package danya.industries.infrastructure.proxy;

/**
 * @author danya
 */

public interface ProxyConfigurator {
    Object replaceWithProxyIfNeeded(Object t, Class<?> implClass);
}
