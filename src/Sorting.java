import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int lo, int hi) {
        int i = lo + 1, j = lo, k = lo;
        int p = a[lo];

        for (; i <= hi; i++) {
            if (a[i] < p) {
                if (k != 0) {
                    k++;
                    swap(a, i, k);
                    j++;
                    swap(a, j, k);
                } else {
                    j++;
                    swap(a, i, j);
                }
            } else if (a[i] == p) {
                if (k == 0) {
                    k = j;
                }
                k++;
                swap(a, k, i);
            }
        }

        swap(a, lo, j);

        return new int[] {j, k};
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        int[] m = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0] - 1);
        randomizedQuickSort(a, m[1] + 1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        //test();
    }

    public static void test() {
        Random r = new Random();
        boolean same = true;
        while (same) {
            int l = r.nextInt((10 - 1) + 1) + 1;
            int[] a = new int[l];
            for (int i = 0; i < l; i++) {
                a[i] = r.nextInt(10);
            }

            System.out.println(Arrays.toString(a));

            int[] a1 = Arrays.copyOf(a, a.length);
            int[] original = Arrays.copyOf(a, a.length);

            randomizedQuickSort(a, 0, a.length-1);
            System.out.println("Randomized:"+Arrays.toString(a));
            Arrays.sort(a1);
            System.out.println("Array Sort:"+Arrays.toString(a1));
            same = Arrays.equals(a, a1);

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

