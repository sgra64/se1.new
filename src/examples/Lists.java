package examples;

import java.util.*;


public class Lists implements Runnable {

    @Override
    public void run() {
        System.out.println(String.format("Hello, %s", this.getClass().getSimpleName()));

        List<String> names = List.of("Eric", "Anne", "Leo", "Khaled", "Khaled", "Khaled", "Tim");

        // old-style index loop that can have errors
        for(int i=0; i < names.size(); i++) {
            String name = names.get(i);
        //  System.out.println(name);
        }

        // loop with no indexing
        for(String name : names) {
        //  System.out.println(name);
        }

        // use of: forEach(Consumer<T> acceptor) method from List<T> interface with lambda expression
        names.forEach(name -> {
        //  System.out.println(name);
        });

        // shortest forEach(acceptor) version
        names.forEach(System.out::println);
    }
}