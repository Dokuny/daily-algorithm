import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int cnt = 1;
            boolean isStop = false;
            for (int j = 1; j <= W; j++) {
                for (int k = 1; k <= H; k++) {
                    if (cnt == N) {
                        sb.append(k);
                        if(j < 10)
                            sb.append("0");
                        sb.append(j).append("\n");
                        isStop = true;
                        break;
                    }
                    cnt++;
                }
                if(isStop) break;
                
            }
        }
        System.out.println(sb);
    }
}
