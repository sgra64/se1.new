package examples;

import java.util.*;
import java.util.stream.Collectors;


public class Streams implements Runnable {

    @Override
    public void run() {
        System.out.println(String.format("Hello, %s", this.getClass().getSimpleName()));

        List<String> names = Arrays.asList(new String[] {"Eric", "Khaled", "Anne", "Tim", "Khaled", "Mia", "Amy", "Khaled", "Leo"});

        names.stream()
            .filter(n -> n.length()==4)
            .map(n -> n.toUpperCase())
            .forEach(n -> System.out.print(n + ", "));

        List<String> threeLetterNamesSorted = names.stream()
            .filter(n -> n.length()==3)
            .map(n -> n.toUpperCase())
            .sorted()
            .collect(Collectors.toList());

        System.out.println(String.format("\n%s", threeLetterNamesSorted));

        String name = "Khaled";
        long countKhaled = names.stream()
            .filter(n -> n.equals(name))
            .count();
        //
        System.out.println(String.format("%s, %dx", name, countKhaled));
    }
}