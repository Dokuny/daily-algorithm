package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2444 {

    static StringBuilder sb;
    static int[] cnt = {1, 1, 2, 2, 2, 8};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        stamp(N, " ", "*", false);
        stamp(N-1, " ", "*", true);


        System.out.println(sb);
    }

    static void stamp(int n, String a, String b, boolean reverse) {
        for (int i = 0; i < n; i++) {
            if (reverse) {
                for (int j = 0; j < i + 1; j++) {
                    sb.append(a);
                }
                for (int j = 0; j < 2*(n-i) -1; j++) {
                    sb.append(b);
                }
            } else {
                for (int j = 0; j < n - i - 1; j++) {
                    sb.append(a);
                }
                for (int j = 0; j < i * 2 + 1; j++) {
                    sb.append(b);
                }
            }

            sb.append("\n");
        }
    }
}
