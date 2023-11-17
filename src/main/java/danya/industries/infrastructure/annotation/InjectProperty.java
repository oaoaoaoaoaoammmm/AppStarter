package danya.industries.infrastructure.annotation;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author danya
 */

@Retention(RUNTIME)
public @interface InjectProperty {
    String value() default "";
}
