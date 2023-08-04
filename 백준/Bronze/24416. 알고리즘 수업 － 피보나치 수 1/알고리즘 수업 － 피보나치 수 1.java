import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new long[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= N; i++) {
            fibonacci(i);
        }
        System.out.println(dp[N] + " " + (N-2));
    }

    public static long fibonacci(int n) {
        if (n <= 2) return 1;
        return dp[n] = dp[n - 2] + dp[n - 1];
    }


}
