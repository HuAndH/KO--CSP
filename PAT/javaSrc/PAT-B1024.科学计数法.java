import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = in.readLine().split("E");
        StringBuilder sb = new StringBuilder(strings[0]);
        int b = Integer.parseInt(strings[1]);
        // 删除小数点
        sb.deleteCharAt(2);

        if (b > 0) {
            int c = b - (sb.length() - 2);
            // 小数部分长度大于指数
            if (c < 0) {
                sb.insert(b + 2, ".");
            } else {
                while (c-- > 0) {
                    sb.append("0");
                }
            }
        } else if (b < 0) {
            while (b++ < 0) {
                sb.insert(1, "0");
            }
            sb.insert(2, ".");
        } else {
            sb.insert(2, ".");
        }
        if (sb.charAt(0) == '+') {
            // 注意格式，‘+’ 要省略
            sb.deleteCharAt(0);
        }
        System.out.println(sb.toString());
    }
}