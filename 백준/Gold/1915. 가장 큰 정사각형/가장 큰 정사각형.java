import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

	static int[][] dirs = {{-1, 0}, {-1, -1}, {0, -1}};
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String input = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = input.charAt(j - 1) - '0';
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if(map[i][j] == 0) continue;

				int min = Integer.MAX_VALUE;

				for (int[] dir : dirs) {
					int mx = j + dir[0];
					int my = i + dir[1];

					min = Math.min(min, map[my][mx]);
				}

				map[i][j] += min;

			}
		}

		int answer = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] > answer) {
					answer = map[i][j];
				}
			}
		}
		System.out.println(answer * answer);
	}
}