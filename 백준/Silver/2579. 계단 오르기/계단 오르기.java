import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // i번째 계단은 dp[i-1] or dp[i-2] + i값을 한 것.

        int[] arr = new int[N + 1];

        // 0 : 한칸 전 , 1 : 두칸 전
        int[][] dp = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0][0] = dp[0][1] = 0;
        dp[1][0] = dp[1][1] = arr[1];

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1] + arr[i];
            dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + arr[i];
        }

        System.out.println(Math.max(dp[N][0],dp[N][1]));

    }
}
