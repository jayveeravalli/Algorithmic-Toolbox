import java.util.Scanner;

public class Fibonacci {

  /* Recursive algorithm with exponential growth
      Took 4 sec to calc calc_fib(45)
   */
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }

  /* Iterative Algorithm
      Took 0 sec to calc fib(45)
   */
  private static long fib(int n) {
    if (n == 0) {
      return 0;
    }

    if (n == 1) {
      return 1;
    }

    int[] cache = new int[n+1];
    cache[0] = 0;
    cache[1] = 1;

    for (int i = 2; i < cache.length; i++) {
      cache[i] = cache[i-1] + cache[i-2];
    }

    return cache[n];

  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(fib(n));
  }
}
