import java.util.*;
import java.io.*;

public class CarFueling {

    private static int computeMinRefills(int dist, int tank, int[] stops) {

        int remaining = tank;
        int prev = -1;
        int i = 0;
        int refills = 0;

        while ( i < stops.length) {

            if (prev == -1) {
                if (stops[i] > tank) {
                    return -1;
                }

                remaining = tank - stops[i];
                prev = i;
                i++;
                continue;
            }

            if (stops[i] - stops[prev] > tank) {
                return -1;
            }

            remaining = remaining - (stops[i] - stops[prev]);

            if (remaining == 0) {
                remaining = tank;
                prev = i;
                i++;
                refills++;
                continue;
            }

            if (remaining < 0 ) {
                remaining = tank;
                refills++;
                continue;
            }

            prev = i;
            i++;


        }

        if (remaining == tank && dist - stops[stops.length-1] >remaining) {
            return -1;
        }

        if (dist - stops[stops.length-1] <= remaining) {
            return refills;
        } else {
            return refills+1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
