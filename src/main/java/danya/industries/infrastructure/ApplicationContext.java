package danya.industries.infrastructure;

import danya.industries.infrastructure.annotation.Singleton;
import danya.industries.infrastructure.config.Config;
import danya.industries.infrastructure.factory.ObjectFactory;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Application context. Context can give object by Class. Class can be an interface.Class or a class.Class
 * @author danya
 */

public class ApplicationContext {
    @Setter
    private ObjectFactory factory;

    private final Map<Class<?>, Object> cache = new ConcurrentHashMap<>();

    @Getter
    private Config config;

    public ApplicationContext(Config config) {
        this.config = config;
    }

    @SuppressWarnings("unchecked")
    public <T> T getObject(Class<T> type) {

        if (cache.containsKey(type)) {
            return (T) cache.get(type);
        }

        Class<? extends T> implClass = type;

        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }

        T t = factory.createObject(implClass);

        if (implClass.isAnnotationPresent(Singleton.class)) {
            cache.put(type, t);
        }

        return t;
    }
}
