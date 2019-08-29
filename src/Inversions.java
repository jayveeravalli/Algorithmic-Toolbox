import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int lo, int hi) {
        long numberOfInversions = 0;
        if (lo >= hi) {
            return numberOfInversions;
        }

        int mid = lo + (hi - lo) / 2;
        numberOfInversions += getNumberOfInversions(a, b, lo, mid);
        numberOfInversions += getNumberOfInversions(a, b, mid + 1, hi);
        numberOfInversions += merge(a, b, lo, hi);

        return numberOfInversions;

    }

    private static long merge(int[] a, int[] b, int lo, int hi) {
        long numberOfInversions = 0;

        int mid = lo + (hi - lo) / 2;

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            b[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = b[j++];
            else if (j > hi)
                a[k] = b[i++];
            else {
                if (b[j] < b[i]) {
                    numberOfInversions += (mid - i + 1);
                    a[k] = b[j++];
                } else {
                    a[k] = b[i++];
                }
            }

        }

//        System.out.println("B:"+Arrays.toString(b));
//        System.out.println("A:"+Arrays.toString(a));
//        System.out.println("Inversions:"+numberOfInversions);

        return numberOfInversions;
    }


    private static long testMethod(int[] a) {
        long count = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
//        test();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        //int a[] = {6, 5, 2, 4, 3, 3, 9, 1};

        System.out.println(getNumberOfInversions(a, new int[a.length], 0, a.length-1));
    }

    private static void test() {
        Random r = new Random();
        boolean same = true;
        while (same) {
            int l = r.nextInt((10 - 1) + 1) + 1;
            int[] a = new int[l];
            for (int i = 0; i < l; i++) {
                a[i] = r.nextInt(10);
            }

            int[] c = Arrays.copyOf(a, a.length);

            int[] b = new int[l];

            System.out.println(Arrays.toString(a));

            long a1 = getNumberOfInversions(a, b, 0, a.length - 1);
            long a2 = testMethod(c);

            System.out.println("Mine:" + a1);
            System.out.println("Brute:" + a2);

            same = (a1 == a2);
        }
    }
}

