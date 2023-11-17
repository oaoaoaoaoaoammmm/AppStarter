package danya.industries.infrastructure.annotation.impl;

import danya.industries.infrastructure.ApplicationContext;

/**
 * @author danya
 */

public interface ObjectConfigurator {
    void configure(Object t, ApplicationContext context);
}
