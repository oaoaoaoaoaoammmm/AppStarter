package danya.industries.ntrfc;

import danya.industries.infrastructure.annotation.InjectProperty;
import danya.industries.infrastructure.annotation.Singleton;

@Singleton
public class MyServiceImpl implements MyInterface{

    @InjectProperty
    private String name;

    @Override
    public void hello() {
        System.out.println("Hello from " + name + "!, I'm Singleton");
    }
}
