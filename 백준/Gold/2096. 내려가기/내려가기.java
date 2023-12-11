import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


	static int[] dirs = {-1, 0, 1};


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][3];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[N][3];
		dp[0][0] = map[0][0];
		dp[0][1] = map[0][1];
		dp[0][2] = map[0][2];

		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < 3; j++) {
				for (int dir : dirs) {
					int x = j + dir;

					if (x < 0 || x >= 3) {
						continue;
					}

					int point = dp[i][j] + map[i+1][x];

					if (dp[i+1][x] >= point) {
						continue;
					}

					dp[i+1][x] = point;
				}
			}
		}

		int max = Math.max(dp[N - 1][0], Math.max(dp[N - 1][1], dp[N - 1][2]));

		dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		dp[0][0] = map[0][0];
		dp[0][1] = map[0][1];
		dp[0][2] = map[0][2];

		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < 3; j++) {
				for (int dir : dirs) {
					int x = j + dir;

					if (x < 0 || x >= 3) {
						continue;
					}

					int point = dp[i][j] + map[i + 1][x];

					if (dp[i+1][x] <= point) {
						continue;
					}

					dp[i + 1][x] = point;
				}
			}
		}

		int min = Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2]));

		System.out.println(max + " " + min);

	}

}

