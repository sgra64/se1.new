package examples;

import java.util.*;


public class Sets implements Runnable {

    @Override
    public void run() {
        System.out.println(String.format( "Hello, %s", this.getClass().getSimpleName()));

        Set<String> names = new HashSet<>();
        names.add("Eric");
        names.add("Anne");
        names.add("Leo");
        names.add("Khaled");
        names.add("Khaled");
        names.add("Khaled");
        names.add("Tim");

        // old-style index loop that can have errors
//      for(int i=0; i < names.size(); i++) {
//          String name = names.get(i);
////        System.out.println(name);
//      }

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