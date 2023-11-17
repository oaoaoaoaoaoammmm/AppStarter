package danya.industries.clss;

import danya.industries.infrastructure.annotation.InjectByType;
import danya.industries.infrastructure.annotation.InjectProperty;
import danya.industries.infrastructure.annotation.Singleton;

@Singleton
public class MyMainService {
    @InjectByType
    private MyService myService;

    @InjectProperty("name")
    private String name;

    public void hello() {
        System.out.println("Hello from " + name + "! I'm singleton!");
        myService.hello();
    }
}
