import java.util.*;

public class FibonacciPartialSum {

    private static List<Integer> list = new ArrayList<>();

    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }

    private static int pisano_period(int modulo) {
        int prev = 0;
        int curr = 1;
        boolean found = false;

        list.add(prev);
        list.add(curr);

        while (!found) {
            int temp = (curr+prev) % modulo;
            if (temp == 1 && curr == 0){
                found = true;
            } else {
                prev = curr;
                curr = temp;
                list.add(temp);
            }
        }

        return list.size()-1;
    }

    private static int total_sum(int n) {
       return list.subList(0, n+1).stream().mapToInt(Integer::intValue).sum();
    }

    private static int getFibonacci(long from, long to) {

        if(from == 0 && to == 0) {
            return 0;
        }

        int pisano_period = pisano_period(100);

        if (from == 0) {
            return list.get((int) ((to + 2) % pisano_period)) % 10 - 1;

        }

        if (from == to) {
            return list.get((int)(to%pisano_period)) % 10;
        }

        int to_sum = list.get((int)((to+2)%pisano_period)) - 1;
        int from_sum = list.get((int)((from+1)%pisano_period)) - 1;

        if (from_sum > to_sum)
            to_sum = 100 + to_sum;

        return (to_sum - from_sum) % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacci(from, to));
    }
}

