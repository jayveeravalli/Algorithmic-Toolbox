import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        StringBuilder result = new StringBuilder();
        boolean[] visited = new boolean[a.length];

        for (int i = 0; i < a.length; i++) {
            int pos = 0;
            int index = 0;
            String max = "0";

            while (pos < a.length) {
                if (!visited[pos] && greaterThanMax(max, a[pos])){
                    max = a[pos];
                    index = pos;
                }
                pos++;
            }
            result.append(max);
            visited[index] = true;
        }

        return result.toString();
    }

    private static boolean greaterThanMax(String max, String value) {
        String a = max+value;
        String b = value+max;

        return Integer.parseInt(a) < Integer.parseInt(b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

