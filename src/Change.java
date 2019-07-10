import java.util.Scanner;

public class Change {

    private static int getChange(int m) {

        if (m == 0){
            return 0;
        }

        int coins = 0;
        int temp = 0;

        if (m >= 10) {
            coins = coins + (m/10);
            m = m%10;
        }

        if (m >= 5) {
            coins = coins + (m/5);
            m = m%5;
        }

        return coins + m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

