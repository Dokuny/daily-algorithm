import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];

        int cnt = 1;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cnt; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            cnt++;
        }

        dp[0][0] = arr[0][0];
        // 자기 자신과 오른쪽
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i + 1][j] = Math.max(dp[i][j] + arr[i + 1][j], dp[i + 1][j]);
                dp[i + 1][j + 1] = Math.max(dp[i][j] + arr[i + 1][j + 1], dp[j + 1][j + 1]);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[N - 1][i]);
        }
        System.out.println(max);
    }
}
