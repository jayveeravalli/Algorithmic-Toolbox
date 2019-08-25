import java.util.*;
import java.io.*;

public class MajorityElement {

    /**
     * Good job! (Max time used: 0.45/1.50, max memory used: 48398336/536870912.)
     *
     * Time : O(n)
     * Space: O(n)
     */

    private static int getMajorityElement(int[] a, int left, int right) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int value : a) {
            map.merge(value, 1, Integer::sum);
        }

        for (Map.Entry entry : map.entrySet()) {
            if ((int) entry.getValue() > a.length / 2) {
                return 1;
            }
        }

        return 0;
    }

    /**
     * Good job! (Max time used: 0.46/1.50, max memory used: 48721920/536870912.)
     *
     * Time O(n)
     * Space O(n)
     **/
    private static int getMajorityElement2(int[] a, int left, int right) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int value : a) {
            int count = 1;
            if (map.containsKey(value)) {
                count = map.get(value);
                count = count + 1;
            }
            map.put(value, count);
            max = Math.max(count, max);
        }

        if (max > a.length / 2) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Good job! (Max time used: 0.34/1.50, max memory used: 43737088/536870912.
     *
     * Time O(nlogn)
     * Space O(1)
     * **/

    private static int getMajorityElement3(int[] a, int left, int right) {
        if (left >= right) {
            return a[left];
        }

        int mid = left + (right - left) / 2;

        int L = getMajorityElement3(a, left, mid);
        int R = getMajorityElement3(a, mid + 1, right);

        if (L == R)
            return L;

        if (L == -1) {
            if (majorityElement(a, left, right, R))
                return R;
        } else if (R == -1) {
            if (majorityElement(a, left, right, L))
                return L;
        } else {
            boolean leftHasMajority = majorityElement(a, left, right, L);
            boolean rightHasMajority = majorityElement(a, left, right, R);

            if (leftHasMajority) {
                return L;
            } else if (rightHasMajority) {
                return R;
            } else {
                return -1;
            }

        }

        return -1;
    }

    /**
     * Good job! (Max time used: 0.30/1.50, max memory used: 44728320/536870912.)
     *
     * Time O(n)
     * Space O(1)
     * **/
    private static boolean boyer_moore_algorithm(int[] a) {
        int count = 0;
        int candidate = 0;

        for (int i : a) {
            if (count == 0) {
                candidate = i;
            }

            count += (candidate == i) ? 1 : -1;
        }



        return majorityElement(a, 0, a.length-1, candidate);
    }

    private static boolean majorityElement(int[] a, int lo, int hi, int V) {
        int count = 0;

        for (int i = lo; i <= hi; i++) {
            if (a[i] == V)
                count++;
        }

        return count > ((hi - lo + 1) / 2);
    }

    public static void main(String[] args) {

        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

//        int elem = getMajorityElement3(a, 0, a.length - 1);
//        if (elem >= 0) {
//            System.out.println(1);
//        } else {
//            System.out.println(0);
//        }

        int result = boyer_moore_algorithm(a) ? 1 : 0;
        System.out.println(result);
    }

    public static void test() {
        Random r = new Random();
        int suc = 0;
        int dc = 0;
        while (suc == dc) {
            int l = r.nextInt((10 - 1) + 1) + 1;
            int[] a = new int[l];
            for (int i = 0; i < l; i++) {
                a[i] = r.nextInt(10);
            }

            System.out.println(Arrays.toString(a));

            suc = getMajorityElement2(a, 0, a.length);
            System.out.println("Success: "+suc);
            dc = getMajorityElement3(a, 0, a.length - 1) >= 0 ? 1 : 0;
            System.out.println("D&C: "+dc);
        }
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

