import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[] switches = new boolean[N];

        for (int i = 0; i < N; i++) {
            switches[i] = st.nextToken().equals("1");
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            boolean isMan = st.nextToken().equals("1");
            int idx = Integer.parseInt(st.nextToken());

            if (isMan) {
                for (int j = idx-1; j < N; j += idx) {
                    switches[j] = !switches[j];
                }
            } else {
                int left = idx - 2;
                int right = idx;

                switches[idx-1] = !switches[idx-1];
                while (left >= 0 && right < N && switches[left] == switches[right]) {
                    switches[left] = !switches[left--];
                    switches[right] = !switches[right++];
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= switches.length; i++) {
            sb.append(switches[i-1] ? 1 : 0);
            if (i % 20 == 0) {
                sb.append("\n");
            } else {
                sb.append(" ");
            }


        }

        System.out.println(sb);
    }
}
