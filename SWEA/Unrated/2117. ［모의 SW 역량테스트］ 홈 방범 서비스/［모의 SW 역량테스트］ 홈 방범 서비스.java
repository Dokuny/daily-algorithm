import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			// 운영 비용 = K * K + (K - 1) * (K - 1)

			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int answer = 1;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					Queue<Pos> queue = new ArrayDeque<>();
					boolean[][] visited = new boolean[N][N];

					queue.add(new Pos(j,i));
					visited[i][j] = true;

					int K = 2;
					int house = 0;

					if (map[i][j] == 1) {
						house++;
					}

					while (!queue.isEmpty()) {
						int size = queue.size();

						for (int k = 0; k < size; k++) {
							Pos cur = queue.poll();

							for (int[] dir : dirs) {
								int mx = cur.x + dir[0];
								int my = cur.y + dir[1];

								if (mx < 0 || my < 0 || mx >= N || my >= N) {
									continue;
								}

								if (visited[my][mx]) {
									continue;
								}

								if (map[my][mx] == 1) {
									house++;
								}

								visited[my][mx] = true;

								queue.add(new Pos(mx, my));
							}

						}
						// 운영 비용 = K * K + (K - 1) * (K - 1)

						int benefit = M * house - (K * K + (K - 1) * (K - 1));

						if (benefit >= 0) {
							answer = Math.max(answer, house);
						}

						K++;

					}
				}
			}
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");

		}
		System.out.println(sb);
	}

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
