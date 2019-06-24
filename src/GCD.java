import java.util.*;

public class GCD {

  // O(N) solution, not good for large inputs
  private static int gcd_naive(int a, int b) {
    int current_gcd = 1;
    for(int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
  }

  private static long gcd(long a, long b){
    if (b == 0)
      return a;

    return gcd(b, a%b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    boolean test = true;

    /*while(test) {
      Random r = new Random();
      int low = 10;
      int high = 10000000;
      int r1 = r.nextInt(high-low) + low;
      int r2 = r.nextInt(high-low) + low;
      System.out.println("R1:"+r1+", R2:"+r2);
      test = ((int)gcd(r1, r2) == gcd_naive(r1, r2));
    }*/
    System.out.println(gcd(a, b));
  }
}
