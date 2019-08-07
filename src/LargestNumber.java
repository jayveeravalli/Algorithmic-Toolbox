import java.util.*;

public class LargestNumber {
    private static String largestNumber(int[] a) {
        StringBuilder result = new StringBuilder();
        boolean[] visited = new boolean[a.length];
        int L = a.length;
        int max = Integer.MIN_VALUE;

        while (L >= 0) {
            int pos = 0;
            int removed_elem = -1;
            while (pos < a.length) {
                if (!visited[pos] && isGreater(max, a[pos])) {
                    max = a[pos];
                    removed_elem = pos;
                }
                pos++;
            }
            result.append(a[removed_elem]);
            visited[removed_elem] = true;
            L--;
        }

        return result.toString();
    }

    private static boolean isGreater(int curr_max, int element) {
        if (curr_max < 0) {
            return true;
        }

        int curr_max_ = first_digit(curr_max);
        int element_ = first_digit(element);

        if (curr_max_ > element_) {
            return false;
        } else if(curr_max_ < element_) {
            return true;
        } else {
            if (curr_max > element) {
                return false
            } else {

            }
        }
    }

    private static int first_digit(int n) {
        while (n/10 > 0) {
            n = n / 10;
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(largestNumber(a));
    }
}

