import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {

    static long getMaxPairwiseProduct(int[] numbers) {
        int max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product,
                    numbers[first] * numbers[second]);
            }
        }

        return max_product;
    }

    /**
     * Sorting and calculating the sum O(nlogn) - time and space is not constant
     * */

    private static long maxPairWiseProduct(int[] numbers) {
       Arrays.sort(numbers);
       return ((long)numbers[numbers.length - 1] * (long)numbers[numbers.length - 2]);
    }

    private static long maxPairWiseProduct2(int[] numbers) {
        int max1Pos = 0;
        int max2Pos = -1;

        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] > numbers[max1Pos]) {
                max1Pos = i;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (i != max1Pos && (max2Pos == -1 || numbers[i] >= numbers[max2Pos])) {
                max2Pos = i;
            }
        }

        return (long) numbers[max1Pos] * (long) numbers[max2Pos];

    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(maxPairWiseProduct2(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}