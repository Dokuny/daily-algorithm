package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No_2745 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        HashMap<Character, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        String first = st.nextToken();
        int num = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 26; i++) {
            map.put((char)('A' + i), 10 + i);
        }

        for (int i = 0; i < 10; i++) {
            map.put((char)('0' + i), i);
        }

        int sum = 0;
        int digit = 1;
        for (int i = first.length() - 1; i >= 0; i--) {
            char cur = first.charAt(i);

            sum += map.get(cur) * digit;

            digit *= num;
        }

        System.out.println(sum);
    }
}
