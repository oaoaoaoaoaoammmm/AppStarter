package danya.industries;

import danya.industries.clss.MyMainService;
import danya.industries.ntrfc.MyInterface;
import danya.industries.infrastructure.annotation.InjectByType;
import danya.industries.infrastructure.annotation.Singleton;

@Singleton
public class EntryPoint {
    @InjectByType
    MyMainService mainService;
    @InjectByType
    MyInterface myService;

    public void start() {
        mainService.hello();
        myService.hello();
    }
}
