package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;


/**
 * Implementation class of {@link Streams} interface.
 * 
 * @version <code style=color:green>{@value application.package_info#Version}</code>
 * @author <code style=color:blue>{@value application.package_info#Author}</code>
 */
public class StreamsImpl implements Streams, Runnable {

    /*
     * arguments passed from command line
     */
    final String[] args;

    /*
     * Random generator.
     */
    final Random rand = new Random();


    /**
     * Public {@code String[] args} constructor.
     * @param args arguments passed from command line
     */
    public StreamsImpl(String[] args) {
    	this.args = args;
    }


    /*
     * Function variable with Lambda expression that accepts one argument and
     * returns a Stream of random Integer numbers between [1, upperBound].
     */
    final Function<Integer, Stream<Integer>> randIntStream =
    		(upperBound)  -> Stream.generate(() -> rand.nextInt(1, upperBound));


	@Override
	public void run() {
		//
		var res = tenRandomNumbers();
		System.out.println(format("tenRandomNumbers()", null, res));
		//
		res = tenEvenRandomNumbers();
		System.out.println(format("tenEvenRandomNumbers()", null, res));
		//
		res = tenSortedEvenRandomNumbers();
		System.out.println(format("tenSortedEvenRandomNumbers()", null, res));
		//
		res = filteredNumbers(0, 15);			// 15 random even numbers
		System.out.println(format("filteredNumbers(0, 15)", "// 15 random even numbers", res));
		//
		res = filteredNumbers(1, 15);			// 15 random numbers divisible by 3
		System.out.println(format("filteredNumbers(1, 15)", "// 15 random numbers divisible by 3", res));
		//
		res = filteredNumbers(2, 15);			// 15 random prime numbers
		System.out.println(format("filteredNumbers(2, 15)", "// 15 random two-digit prime numbers", res));
		//
		var nams = filteredNames(names, ".*ez$");	// names ending with "ez"
		System.out.println(format("filteredNames(names, \".*ez$\")", "// names ending with \"ez\"", nams));
		//
		nams = sortedNames(names, 8);		// first 8 names from sorted name list
		System.out.println(format("sortedNames(names, 8)", "// first 8 names from sorted name list", nams));
		//
		nams = sortedNamesByLength(names);		// names sorted by length and alphabetically for names with same length
		System.out.println(format("sortedNamesByLength(names)", "// names sorted by length", nams));
		//
		long value = calculateValue(orders);
		System.out.println(format("calculateValue(orders)", null, value));
		//
		StringBuilder ord = sortOrdersByValue(orders).stream()
				.map(o -> o.toString())
				.reduce(new StringBuilder(""), 
	                (acc, str) -> acc.append(str).append("\n"), 
	                (sb1, sb2) -> sb1.append(sb2));
		//
		ord.append(" ".repeat(26)).append("--------\n");
		ord.append(" ".repeat(26)).append(String.format("%8d\n", value));
		ord.append(" ".repeat(26)).append("========\n");
		//
		System.out.println(format("sortOrdersByValue(orders)", "// orders sorted by value", ord));
	}


	/**
	 * Aufgabe 1: Return 10 random integer numbers generated from a Stream<Integer>.
	 * @return 10 random numbers
	 */
	@Override
	public List<Integer> tenRandomNumbers() {
		List<Integer> result = new ArrayList<>();

        /*
         * TODO: write code to implement the method
         */
        return result;
	}


	/**
	 * Aufgabe 2: Return 10 even random integer numbers generated from a Stream<Integer>.
	 * @return 10 even random numbers
	 */
	@Override
	public List<Integer> tenEvenRandomNumbers() {
		List<Integer> result = new ArrayList<>();

        /*
         * TODO: write code to implement the method
         */
        return result;
	}


    /**
     * Aufgabe 3: Return 10 even sorted random integer numbers generated from a Stream<Integer>.
     * @return 10 even sorted random numbers
     */
	@Override
	public List<Integer> tenSortedEvenRandomNumbers() {
		List<Integer> result = new ArrayList<>();

        /*
         * TODO: write code to implement the method
         */
        return result;
	}


    /**
     * Aufgabe 4: Method applies function from {@link filterFunctions} to a stream
     * of integer numbers returning only numbers matching the selected filter:
     * <pre>
     *  - 0: only even numbers
     *  - 1: only numbers divisible by 3
     *  - 2: only 3-digit prime numbers
     * </pre>
     * @param filterFunctionIndex index of filter function in {@link filterFunctions}
     * @param limit amount of numbers returned
     * @return numbers matching the selected filter
     */
	@Override
	public List<Integer> filteredNumbers(int filterFunctionIndex, int limit) {
		//
		int size = filterFunctions.size();
		if(filterFunctionIndex < 0 || (size > 0 && filterFunctionIndex >= size))
			throw new IndexOutOfBoundsException(String.format("filterFunctionIndex out of range: %d", filterFunctionIndex));
		//
		if(limit < 0)
			throw new IllegalArgumentException(String.format("negative limit: %d", limit));

        /*
         * TODO: write code to implement the method
         * use lambda expressions from {@link filterFunctions} (see {@link Streams} interface)
         */
        return List.of();
	}


    /**
     * Aufgabe 5: Return sub-list from input names filtered by a regular expression.
     * Order of names remains unchanged, regular expression refers to {@link java.util.regex.Pattern}.
     * @param names input names
     * @param regex regular expression according to {@link java.util.regex.Pattern}
     * @return sub-list of names
     */
	@Override
	public List<String> filteredNames(List<String> names, String regex) {

        /*
         * TODO: write code to implement the method
         */
        return List.of();
	}


    /**
     * Aufgabe 6: Return alphabetically sorted list of names up to limit.
     * @param names input names
     * @param limit maximum number of names returned
     * @return alphabetically sorted list of names up to limit
     */
	@Override
	public List<String> sortedNames(List<String> names, int limit) {

        /*
         * TODO: write code to implement the method
         */
        return List.of();
	}


    /**
     * Aufgabe 7: Return list of names sorted by name length (first criteria)
     * and alphabetically (second criteria) for names of equal length.
     * @param names input names
     * @return names sorted by name length
     */
	@Override
	public List<String> sortedNamesByLength(List<String> names) {

        /*
         * TODO: write code to implement the method
         */
        return List.of();
	}


    /**
     * Aufgabe 8: Calculate value of orders.
     * @param orders list of orders to process
     * @return value of orders
     */
	@Override
	public long calculateValue(List<Order> orders) {

        /*
         * TODO: write code to implement the method
         */
        return 0L;
	}


    /**
     * Aufgabe 9: Return list of orders sorted by order value (highest-value first).
     * @param orders list to sort
     * @return orders sorted by order value (highest-value first)
     */
	@Override
    public List<Order> sortOrdersByValue(List<Order> orders) {

        /*
         * TODO: write code to implement the method
         */
        return List.of();
	}


	/**
	 * Return formatted output from parameters.
	 * @param func function name invoked
	 * @param comment provided comment
	 * @param result result to show
	 * @return formatted output
	 */
    private String format(String func, String comment, Object result) {
    	var cmt = comment==null? "" : "\t" + comment;
    	return String.format("- %s:%s\n    -> %s\n", func, cmt, result);
    }
}