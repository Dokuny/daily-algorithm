import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[][] map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE);
			map[i][i] = 0;
		}

		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			map[start][end] = Math.min(dist, map[start][end]);
		}

		for (int m = 1; m <= N; m++) {
			for (int s = 1; s <= N; s++) {
				for (int e = 1; e <= N; e++) {
					if (map[s][m] != Integer.MAX_VALUE && map[m][e] != Integer.MAX_VALUE) {
						map[s][e] = Math.min(map[s][e], map[s][m] + map[m][e]);
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sb.append(map[i][j] == Integer.MAX_VALUE ? 0 : map[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}

