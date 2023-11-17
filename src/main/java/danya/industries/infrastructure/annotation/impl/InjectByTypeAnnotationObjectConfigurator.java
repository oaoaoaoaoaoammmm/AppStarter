package danya.industries.infrastructure.annotation.impl;

import danya.industries.infrastructure.ApplicationContext;
import danya.industries.infrastructure.annotation.InjectByType;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

/**
 * InjectByTypeAnnotationObjectConfigurator for @InjectByType
 * @author danya
 */

public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object t, ApplicationContext context) {
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                field.setAccessible(true);
                Object object = context.getObject(field.getType());
                field.set(t, object);
            }
        }
    }
}
