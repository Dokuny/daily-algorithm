import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 23.07.30
 */
public class Main {

	static int N;
	static int[][] arr;

	static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];
		dp[0] = 1;
		dp[1] = 1;


		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
		}

		System.out.println(dp[N]);
	}

}
