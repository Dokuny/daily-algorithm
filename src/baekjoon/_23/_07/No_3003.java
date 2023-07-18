package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_3003 {

    static int[] cnt = {1, 1, 2, 2, 2, 8};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 6; i++) {
            sb.append(cnt[i] - Integer.parseInt(st.nextToken()))
                    .append(" ");
        }
        System.out.println(sb);
    }
}
