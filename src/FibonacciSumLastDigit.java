import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

    private static int getFibonacciSum(long n) {
        if (n <= 1)
            return (int)n;

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);

        boolean found = false;
        int i = 2;
        int pisanoPeriod = 0;

        while (!found) {
            int last = list.get(i-1);
            int temp = (last + list.get(i-2))%10;
            if((last == 0) && (last + temp == 1)) {
                found = true;
            } else {
                list.add(temp);
                i++;
            }
        }

        pisanoPeriod = list.size()-1;

        int index = (int)((n+1)%pisanoPeriod);

        int sum = 0;

        for(int j=0; j<index; j++) {
            sum+=list.get(j);
        }

        return sum%10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSum(n);

        /*boolean first = true;
        // For testing purpose
        for (int i = 0 ; i < 50; i++) {
            System.out.println("I:" + i);
            System.out.println("Mine: " + getFibonacciSum(i));
            System.out.println("Naive: " + getFibonacciSumNaive(i));
            System.out.println(getFibonacciSum(i) == getFibonacciSumNaive(i));
        }*/

        System.out.println(s);
    }
}

