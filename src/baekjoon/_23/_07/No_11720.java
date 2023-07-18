package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_11720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();

        int sum = 0;

        String num = br.readLine();
        for (int i = 0; i < num.length(); i++) {
            sum += num.charAt(i) - '0';
        }

        System.out.println(sum);
    }
}
