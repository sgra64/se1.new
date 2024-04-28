package examples;

import java.util.*;


public class Optionals implements Runnable {

    class Articles {
        final Map<String, Integer> prices;

        Articles(Map<String, Integer> prices) {
            this.prices = prices;
        }
        
        Optional<Integer> getPrice(String article) {
            return Optional.ofNullable(prices.get(article));
        }
    }

    @Override
    public void run() {
        System.out.println(String.format("Hello, %s", this.getClass().getSimpleName()));

        Articles articles = new Articles(Map.of("Tasse", 999, "Kanne", 1999, "Becher", 749));
        //
        String article = "Messer";
        String answer = articles.getPrice(article) // Optional-methods: map(), orElse() yield the correct result
            .map(p -> String.format("Der Preis für %s ist: %d", article, p))
            .orElse(String.format("Der Artikel %s konnte nicht gefunden werden", article));
        //
        System.out.println(answer);
    }
}