import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 0 : 한칸 이전 , 1 : 두칸(세칸,네칸 등등) 이전
        int[][] dp = new int[N + 1][2];
        dp[1][0] = dp[1][1] = arr[1];

        int prev2Max = Integer.MIN_VALUE;
        int left = 0;
        int max = arr[1];
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1] + arr[i];

            while (left < i - 1) {
                prev2Max = Math.max(prev2Max, Math.max(dp[left][0], dp[left][1]));
                left++;
            }

            dp[i][1] = prev2Max + arr[i];
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        System.out.println(max);
    }
}
