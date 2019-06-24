import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        //System.out.println(current);

        return current % m;
    }

    private static long getFibonnaci(long n, long m) {
        if (n <= 1) {
            return n;
        }

        boolean found = false;
        int series_length = 0;
        long previous = 1;
        List<Long> l = new ArrayList<>();
        l.add(0L);
        l.add(1L);
        int pos = 2;

        while (!found) {
            long temp = (l.get((int)pos-1) + l.get((int)pos-2))%m;
            if (previous == 0  && (temp == 1)) {
                series_length =  l.size() - 1;
                found = true;
            } else {
                l.add(temp);
                previous = temp;
                pos++;
            }
        }

        /*for (int i = 0; i< l.size(); i++){
            System.out.println(i+":"+l.get(i));
        }

        System.out.println(series_length);*/

        return l.get((int)(n%series_length));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();

        /*long n = 9999999999999L;
        long m = 5;*/

        //System.out.println(getFibonacciHugeNaive(n,m));

        System.out.println(getFibonnaci(n, m));
    }
}

