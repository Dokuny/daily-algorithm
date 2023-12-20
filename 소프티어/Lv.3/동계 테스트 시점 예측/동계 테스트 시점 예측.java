import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 겉부분 BFS
		ArrayDeque<Point> queue = new ArrayDeque<>();

		int time = 0;
		while (true) {

			queue.add(new Point(0, 0));
			boolean[][] visited = new boolean[N][M];
			visited[0][0] = true;

			while (!queue.isEmpty()) {
				Point cur = queue.poll();

				for (int[] dir : dirs) {
					int mx = cur.x + dir[0];
					int my = cur.y + dir[1];

					if(mx < 0 || my < 0 || mx >= M || my >= N) continue;
					if(visited[my][mx]) continue;
					if (map[my][mx] != 0) {
						map[my][mx]++;
					} else {
						queue.add(new Point(mx, my));
						visited[my][mx] = true;
					}
				}
			}

			int zeroCnt = 0;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						zeroCnt++;
						continue;
					}

					if (map[i][j] >= 3) {
						map[i][j] = 0;
					} else {
						map[i][j] = 1;
						cnt++;
					}
				}
			}

			if (zeroCnt == M * N) {
				break;
			}
			time++;

			if (cnt == 0) {
				break;
			}

		}

		System.out.println(time);

	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
