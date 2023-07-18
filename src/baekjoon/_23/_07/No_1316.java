package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class No_1316 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<Character>();
            String str = br.readLine();

            char prev = str.charAt(0);
            boolean check = true;
            set.add(prev);
            for (int j = 0; j < str.length(); j++) {
                if (prev == str.charAt(j)) {
                    continue;
                }
                prev = str.charAt(j);
                if (set.contains(prev)) {
                    check = false;
                    break;
                } else {
                    set.add(prev);
                }
            }

            if (check) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
