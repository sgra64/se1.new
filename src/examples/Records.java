package examples;

import java.util.*;


public class Records implements Runnable {


    @Override
    public void run() {
        System.out.println(String.format("Hello, %s", this.getClass().getSimpleName()));

        Map<String, Integer> articleMap = Map.of("Tasse", 999, "Messer", 555, "Kanne", 1999, "Becher", 749);

        /**
         * Record for an Article with attributes: name and price
         */
        record Article(String name, int price) {

            @Override
            public String toString() {
                return String.format(" - Artikel: %s,\tPreis: %4d", name, price);
            }
        };

        // convert Map<String, Integer> to List<Article>, sorted by price
        List<Article> articles = articleMap.keySet().stream()
            // .peek(System.out::println)	// print keys
            .map(k -> new Article(k, articleMap.get(k)))
            .sorted( (a1, a2) -> Integer.compare(a1.price, a2.price))
            .toList();

        // print articles
        articles.forEach(System.out::println);
    }
}