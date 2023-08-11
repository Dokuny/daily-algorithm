import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long sum = 1;

        for (int i = 0; i < 3; i++) {
            sum *= Long.parseLong(br.readLine());
        }

        int[] cnt = new int[10];
        String str = String.valueOf(sum);
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i)-'0']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(cnt[i]).append("\n");
        }
        System.out.println(sb);
    }
}
