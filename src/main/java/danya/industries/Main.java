package danya.industries;

import danya.industries.infrastructure.Application;
import danya.industries.infrastructure.ApplicationContext;

import java.util.HashMap;

/**
 * Main
 *
 * @author danya
 */

public class Main {
    public static void main(String[] args) {
        //TODO map must build
        ApplicationContext context = Application.run("danya.industries", new HashMap<>());

        EntryPoint entryPoint = context.getObject(EntryPoint.class);
        entryPoint.start();
    }
}