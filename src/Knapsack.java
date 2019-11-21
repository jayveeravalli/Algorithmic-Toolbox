import java.util.*;

public class Knapsack {

    private static int optimalWeight(int W, int[] w) {

        int[][] dp = new int[w.length + 1][W + 1];

        for (int i = 1; i < w.length + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int notPresent = dp[i - 1][j];
                int present = Integer.MIN_VALUE;

                if (w[i - 1] <= j) {
                    present = dp[i - 1][j - w[i - 1]] + w[i - 1];
                }

                dp[i][j] = Math.max(notPresent, present);
            }
        }

        return dp[w.length][W];
    }

    private static void print(int[][] grid) {
        for (int[] ints : grid) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

