import jdk.internal.dynalink.linker.LinkerServices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EditDistance {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(minDistance(s, t));

    }

    private static int minDistance(String word1, String word2) {

        int n = word2.length() + 1;
        int m = word1.length() + 1;

        int[][] matrix = new int[m][n];

        for(int i = 0; i < m; i++) {
            matrix[i][0] = i;
        }

        for(int j = 0; j < n; j++) {
            matrix[0][j] = j;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {

                int diff = diff(word1.charAt(i-1), word2.charAt(j-1));
                int sub = matrix[i-1][j-1] + diff;
                int ins = matrix[i][j-1] + 1;
                int del = matrix[i-1][j] + 1;

                matrix[i][j] = min(sub, ins, del);
            }
        }

        return matrix[m-1][n-1];
    }

    private static int diff(char a, char b) {
        return (a == b) ? 0 : 1;
    }

    private static int min(int a, int b, int c) {
        int temp = Math.min(a, b);
        return Math.min(temp, c);
    }
}
