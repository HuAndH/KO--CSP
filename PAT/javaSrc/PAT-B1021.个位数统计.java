import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 定义字符数组
        char[] s = bf.readLine().toCharArray();
        int[] num = new int[10];
        // 数组中的数减 ‘0’， 并计数
        for (int i = 0; i < s.length; i++) {
            num[s[i] - '0'] ++;
        }
        // 按照格式输出
        for (int i = 0; i < 10; i++) {
            if (num[i] != 0) {
                System.out.println(i + ":" + num[i]);
            }
        }
    }
}
