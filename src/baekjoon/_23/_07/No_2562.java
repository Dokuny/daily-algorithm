package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2562 {

    // 배열없이 문제풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.MIN_VALUE;
        int idx = -1;

        for (int i = 1; i <= 9; i++) {
            int num = Integer.parseInt(br.readLine());

            if (max < num) {
                max = num;
                idx = i;
            }

        }

        System.out.println(max+"\n"+idx);
    }
}
