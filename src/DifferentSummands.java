import java.util.*;

public class DifferentSummands {

    private static List<Long> optimalSummands(long n) {
        List<Long> summands = new ArrayList<Long>();
        long i = 1;
        summands.add(i++);
        n = n - 1;

        while (n >= 0 && n > summands.get(summands.size()-1) ) {
            summands.add(i);
            n = n - i;
            i++;
        }

        summands.set(summands.size()-1, summands.get(summands.size()-1)+n);

        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        List<Long> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Long summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

