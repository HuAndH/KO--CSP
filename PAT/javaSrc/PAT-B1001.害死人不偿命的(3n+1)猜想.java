import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int step = 0;// 步长
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = (3 * n + 1) / 2;
            }
            step++;
        }
        System.out.println(step);
    }
}
