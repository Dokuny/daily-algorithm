import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] weights = new int[N + 1];
		int[] values = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			weights[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {

			int weight = weights[i];
			int value = values[i];

			for (int j = 1; j <= K; j++) {
				if (j - weight < 0) {
					dp[i][j] = dp[i - 1][j];
				} else {
					int cur = dp[i - 1][j - weight] + value;
					int prev = dp[i - 1][j];
					dp[i][j] = Math.max(cur, prev);
				}

			}
		}

		int answer = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			answer = Math.max(answer, dp[i][K]);
		}

		System.out.println(answer);

	}

}