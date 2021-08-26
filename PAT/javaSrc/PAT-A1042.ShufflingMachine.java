import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N = 54;
        char[] mp = {'S', 'H', 'C', 'D', 'J'};
        int[] start = new int[N + 1];
        int[] end = new int[N + 1];
        int[] next = new int[N + 1];

        int k = 0;
        Scanner scanner = new Scanner(System.in);
        k = scanner.nextInt();

        for (int i = 1; i <= N; i++) {
            start[i] = i;// 初始化牌的编号
        }
        for (int i = 1; i <= N; i++) {
            next[i] = scanner.nextInt();// 输入每个位置上的牌在操作之后的位置
        }
        for (int step = 0; step < k; step++) {
            for (int i = 1; i <= N; i++) {
                end[next[i]] = start[i];// 把第i个位置的牌的编号存于位置next[i]
            }
            // 把end数组赋值给start数组以供下次操作使用
            System.arraycopy(end, 1, start, 1, N);
        }

        for (int i = 1; i <= N; i++) {
            if (i != 1) {
                System.out.print(" ");// 控制输出格式
            }
            start[i]--;
            System.out.printf("%c%d", mp[start[i] / 13], start[i] % 13 + 1);
        }
    }
}
