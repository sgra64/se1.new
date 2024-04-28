package examples;


public class Functions implements Runnable {

	@FunctionalInterface
	public interface Calculator<T, R> {
	      R calculate(T t);		// only one method
	}

	int calculatePoints(int points, Calculator<Integer, Integer> calculator) {
		int result = calculator.calculate(points);
		return result;
	}

	@Override
	public void run() {
		System.out.println(String.format("Hello, %s", this.getClass().getSimpleName()));

		// function variables: incrementor, decrementor with one argument and returning one argument 
		Calculator<Integer, Integer> incrementor = x -> x + 1;
		Calculator<Integer, Integer> decrementor = x -> x - 1;

		// use of function variables
		int x = incrementor.calculate(10);
		int y = decrementor.calculate(10);
		
		// use of nameless lambda expression that matches the Calculator @FunctionalInterface
		int z = calculatePoints(100, pts -> pts + 10);
	}
}