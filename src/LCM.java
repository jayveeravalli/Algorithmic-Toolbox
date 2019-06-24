import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  private static long lcm(long a, long b) {
    long gcd = gcd(a, b);
    if (gcd == 1)
      return a*b;
    else
      return gcd * lcm(a/gcd, b/gcd);
  }

  private static long gcd(long a, long b) {
    if (b == 0)
      return a;

    return gcd(b, a%b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    /*int a = 18653;
    int b = 46744;
    System.out.println(lcm(a, b));
    System.out.println(lcm_naive(a, b));*/
    /*boolean test = true;

    while(test) {
      Random r = new Random();
      int low = 10;
      int high = 100;
      int r1 = r.nextInt(high-low) + low;
      int r2 = r.nextInt(high-low) + low;
      System.out.println("R1:"+r1+", R2:"+r2);

      long naive = lcm_naive(r1, r2);
      long mine = lcm(r1, r2);
      System.out.println("GCD:"+gcd(r1, r2));
      System.out.println("Mine:"+mine);
      System.out.println("Naive:"+naive);
      test = (mine == naive);
    }*/

    System.out.println(lcm(a, b));
  }
}
