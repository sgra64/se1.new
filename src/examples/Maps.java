package examples;

import java.util.*;
import java.util.Map.Entry;


public class Maps implements Runnable {

	@Override
	public void run() {
		System.out.println(String.format("Hello, %s", this.getClass().getSimpleName()));

		Map<String, Integer> articles = new HashMap<>(Map.of("Tasse", 999, "Kanne", 1999, "Becher", 749));

		var outb = new StringBuffer();

		// old-style iterator loop over map entries
		Iterator<Entry<String, Integer>> it = articles.entrySet().iterator();
		while(it.hasNext()) {
		  Entry<String, Integer> entry = it.next();
		  outb.append(String.format("k: %s, value: %d", entry.getKey(), entry.getValue()));
		}

		// old-style iterator over keys
		Iterator<String> keys = articles.keySet().iterator();
		while(keys.hasNext()) {
		  String key = keys.next();
		  outb.append(String.format("k: %s, value: %d", key, articles.get(key)));
		}

		// loop with no iterators
		for(var entry : articles.entrySet()) {
		  outb.append(String.format("k: %s, value: %d", entry.getKey(), entry.getValue()));
		}

		// forEach(BiConsumer<K,V> acceptor) method from Set<T> interface with lambda expression
		articles.forEach((k, v) -> {
		  outb.append(String.format("k: %s, value: %d\n", k, v));
		});

		System.out.println(outb.toString());
	}
}