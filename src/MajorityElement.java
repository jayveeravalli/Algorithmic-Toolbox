import java.util.*;
import java.io.*;

public class MajorityElement {

    /**
     * Good job! (Max time used: 0.45/1.50, max memory used: 48398336/536870912.)
     * */

    private static int getMajorityElement(int[] a, int left, int right) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int value : a) {
            map.merge(value, 1, Integer::sum);
        }

        for (Map.Entry entry : map.entrySet()) {
            if ((int)entry.getValue() > a.length/2) {
                return 1;
            }
        }

        return 0;
    }

    private static int boyer_moore_algorithm(int[] a){
        int count = 0;
        int candidate = 0;

        for (int i: a) {
            if (count == 0) {
                candidate = i;
            }

            count += (candidate == i) ? 1 : -1;
        }

        if (count >= 1)
            return 1;
        else return 0;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
//        System.out.println(getMajorityElement(a, 0, a.length));
        System.out.println(boyer_moore_algorithm(a));
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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

