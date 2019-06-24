import java.util.*;

public class FibonacciLastDigit {

    // Will Cause Integer Overflow
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        //System.out.println("Current: " + current + ", Previous: " + previous);

        return current % 10;
    }

    private static int getFibonacciLastDigit(int n) {
        if (n <= 1) {
            return n;
        }

        int previousLast = 0;
        int currentLast = 1;

        for (int i = 2; i <= n; i++) {
            int temp = previousLast;
            previousLast = currentLast;
            currentLast = currentLast + temp;

            if (currentLast >= 10) {
                currentLast %= 10;
            }
        }

        return currentLast;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigit(n);

        // For testing purpose
        /*for (int i = 0 ; i < 200; i++) {
            System.out.println("I:" + i);
            System.out.println("Mine: " + getFibonacciLastDigit(i));
            System.out.println("Naive: " + getFibonacciLastDigitNaive(i));
            System.out.println(getFibonacciLastDigit(i) == getFibonacciLastDigitNaive(i));
        }*/

        System.out.println(c);
    }
}

