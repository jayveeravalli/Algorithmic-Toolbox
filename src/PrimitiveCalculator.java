import java.util.*;
import java.util.stream.Collectors;

public class PrimitiveCalculator {

    private static int[] minOperations;


    private static int minOps(int n) {

        if (n < 1)
            throw new IllegalArgumentException();

        if (n == 1) {
            return 0;
        }

        minOperations = new int[n+1];

        minOperations[0] = 0;
        minOperations[1] = 0;

        for (int i = 2; i < n+1; i++) {

            int multiply3 = Integer.MAX_VALUE;
            int multiply2 = Integer.MAX_VALUE;
            int add1 = minOperations[i-1] + 1;

            if (i % 3 == 0) {
                multiply3 = minOperations[i/3] + 1;
            }

            if (i % 2 == 0) {
                multiply2 = minOperations[i/2] + 1;
            }

            minOperations[i] = Math.min(add1, multiply2);
            minOperations[i] = Math.min(minOperations[i], multiply3);

        }

        return minOperations[n];
    }

    private static List<Integer> getSteps(int m) {

        minOps(m);

        List<Integer> list = new ArrayList<>();

        while (m > 0) {
            list.add(m);

            if ( m % 2 != 0 && m % 3 != 0 ) {
                m = m - 1;
            } else if(m % 2 == 0 && m % 3 == 0) {
                m = m / 3;
            } else if (m % 3 == 0) {
                m = (minOps(m-1) > minOps(m/3)) ? m/3 : m-1;
            } else {
                m = (minOps(m-1) > minOps(m/2)) ? m/2 : m-1;
            }
        }

        Collections.reverse(list);

        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = getSteps(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }

    }
}

