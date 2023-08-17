import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] height = new int[257];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                height[Integer.parseInt(st.nextToken())]++;
            }
        }

        int[] dp = new int[257];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i <= 256; i++) {

            int block = B;
            int time = 0;

            int digged = 0;
            // 오른쪽 (블록 캐기)
            for (int j = i + 1; j <= 256; j++) {
                if(height[j] == 0) continue;
                digged += (j - i) * height[j];
            }
            time += digged * 2;
            block += digged;

            int needed = 0;
            // 왼쪽 (블록 쌓기)
            for (int j = 0; j < i; j++) {
                if (height[j] == 0) continue;
                needed += (i - j) * height[j];
            }

            if (needed <= block) {
                time += needed;
                dp[i] = time;
            }
        }

        int maxIdx = 0;
        for (int i = 0; i <= 256; i++) {
            if (dp[i] <= dp[maxIdx]) {
                maxIdx = i;
            }
        }

        System.out.println(dp[maxIdx]+ " " + maxIdx);
    }
}

