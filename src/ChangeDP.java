import java.util.Arrays;
import java.util.Scanner;

public class ChangeDP {

    private static int getChange(int m) {
        int[] coins = {1, 3, 4};
        int[] minCoins = new int[m+1];
        minCoins[0] = 0;

        for (int i = 1; i < m+1; i++) {

            minCoins[i] = Integer.MAX_VALUE;

            for (int j = 0; j < coins.length && coins[j] <= i; j++) {

                minCoins[i] = Math.min(minCoins[i-coins[j]] + 1, minCoins[i]);

            }

        }

        return minCoins[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
