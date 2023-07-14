import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2675 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        // 왜 repeat가 없나 했더니 자바 11부터 생긴 메소드라고 한다.
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            for (int j = 0; j < str.length(); j++) {
                for (int k = 0; k < n; k++) {
                    sb.append(str.charAt(j));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
