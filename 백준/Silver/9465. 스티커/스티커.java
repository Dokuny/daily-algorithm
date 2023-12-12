import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] stickers;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int test_case = 1; test_case <= T; test_case++) {

			int n = Integer.parseInt(br.readLine());

			stickers = new int[2][n + 2];
			int[][] dp = new int[2][n + 2];

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 2; j < n + 2; j++) {
					stickers[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 대각선 혹은 대각선 그 옆을 골라야 함
			for (int x = 2; x < n + 2; x++) {

				// 위 - 좌하단
				dp[0][x] = Math.max(dp[1][x - 2], dp[1][x - 1]) + stickers[0][x];

				// 아래
				dp[1][x] = Math.max(dp[0][x - 2], dp[0][x - 1]) + stickers[1][x];
			}

			sb.append(Math.max(dp[0][n + 1], dp[1][n + 1])).append("\n");

		}
		System.out.println(sb);

	}


}

