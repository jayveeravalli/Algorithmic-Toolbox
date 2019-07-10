import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Item implements Comparable{

    double r;
    int v;
    int w;

    public Item(double r, int v, int w) {
        this.r = r;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Object o) {
        Item value = (Item) o;
        return Double.compare(value.r, this.r);
    }

    @Override
    public String toString() {
        return "Item{" +
                "r=" + r +
                ", v=" + v +
                ", w=" + w +
                '}';
    }
}

public class FractionalKnapsack {


    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        List<Item> list = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            Item temp = new Item((double) values[i]/weights[i], values[i], weights[i]);
            list.add(temp);
        }

        Collections.sort(list);

        return helper(capacity, list);
    }

    private static double helper(int capacity, List<Item> list) {

        double totalValue = 0;

        for (int i = 0; i < list.size(); i++) {

            Item item = list.get(i);

            if (capacity == 0) {
                return totalValue;
            }

            if (capacity > item.w) {

                capacity = capacity - item.w;
                totalValue = totalValue + item.v;

            } else {

                totalValue = totalValue + (item.r * capacity);
                capacity = 0;
            }

        }

        return totalValue;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }

        double value = getOptimalValue(capacity, values, weights);
        DecimalFormat df = new DecimalFormat("#.0000");
        System.out.println(df.format(value));
    }
} 
