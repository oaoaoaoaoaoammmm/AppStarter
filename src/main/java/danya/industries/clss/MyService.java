package danya.industries.clss;

import danya.industries.infrastructure.annotation.Singleton;

@Singleton
public class MyService {

    public void hello() {
        System.out.println("Hello from my service! I'm singleton!");
    }

}
