package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2566 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int max = -1;
        int rIdx = -1;
        int lIdx = -1;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {

                int num = Integer.parseInt(st.nextToken());
                if (max < num) {
                    max = num;
                    rIdx = j;
                    lIdx = i;
                }
            }
        }

        System.out.println(max);
        System.out.println((lIdx+1) +" "+(rIdx+1));
    }
}
