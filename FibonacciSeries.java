import java.util.ArrayList;
import java.util.List;

public class FibonacciSeries {
    public static void main(String[] args) {
        List<Integer> fibonacciSeries = new ArrayList<>();
        fibonacciSeries.add(0);
        fibonacciSeries.add(1);

        int currentFibonacciNumber = 1;
        while (currentFibonacciNumber < 100) {
            int previousFibonacciNumber = fibonacciSeries.get(fibonacciSeries.size() - 2);
            int currentNumber = fibonacciSeries.get(fibonacciSeries.size() - 1);
            currentFibonacciNumber = previousFibonacciNumber + currentNumber;
            fibonacciSeries.add(currentFibonacciNumber);
        }

        System.out.println("Fibonacci Series up to 100:");
        for (int number : fibonacciSeries) {
            System.out.print(number + " ");
        }
    }
}
