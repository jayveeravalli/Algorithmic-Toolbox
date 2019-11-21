import java.util.Arrays;

public class KnapSackWithoutRepitions {

    private static int maxValue(int[] weights, int[] values, int W) {
        int[][] dp = new int[weights.length + 1][W + 1];

        for (int i = 1; i < weights.length + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int notPresent = dp[i - 1][j];
                int present = Integer.MIN_VALUE;

                if (weights[i - 1] <= j) {
                    present = dp[i - 1][j - weights[i - 1]] + values[i - 1];
                }

                dp[i][j] = Math.max(notPresent, present);
            }
        }

        print(dp);

        return dp[weights.length][W];
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
        int[] weights = {2, 3, 4, 6};
        int[] values = {9, 14, 16, 30};
        int W = 10;

        System.out.println(maxValue(weights, values, W));
    }

}
