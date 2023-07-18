package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2908 {

    // 수를 이용해서 풀 수도 있지만 문자열로 물어보기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String f = st.nextToken();
        String s = st.nextToken();
        
        boolean isFBigger = true;
        for (int i = 2; i >= 0; i--) {
            if (f.charAt(i) < s.charAt(i)) {
                isFBigger = false;
                break;
            } else if (f.charAt(i) > s.charAt(i)) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i >= 0; i--) {
            if (isFBigger) {
                sb.append(f.charAt(i));
            } else {
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb);


    }
}
