import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static Pos start;
	static Pos end;
	static int N;
	static int M;
	static int[][] map;
	static boolean[][][] visited;

	static int answer = Integer.MAX_VALUE;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int sy = Integer.parseInt(st.nextToken()) - 1;
		int sx = Integer.parseInt(st.nextToken()) - 1;
		start = new Pos(sx, sy, 0, 0);

		st = new StringTokenizer(br.readLine());
		int ey = Integer.parseInt(st.nextToken()) - 1;
		int ex = Integer.parseInt(st.nextToken()) - 1;
		end = new Pos(ex,
			ey, 0, 0);

		map = new int[N][M];
		visited = new boolean[2][N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Pos> queue = new ArrayDeque<>();
		queue.add(start);
		visited[0][start.y][start.x] = true;

		int answer = -1;
		while (!queue.isEmpty()) {
			Pos cur = queue.poll();

			if (cur.x == end.x && cur.y == end.y) {
				answer = cur.cnt;
				break;
			}

			for (int[] dir : dirs) {
				int x = cur.x + dir[0];
				int y = cur.y + dir[1];

				if (!isMovable(x, y)) {
					continue;
				}
				if (visited[cur.z][y][x]) {
					continue;
				}
				if (map[y][x] == 1) {
					if (cur.z == 1) {
						continue;
					} else {
						if (visited[1][y][x]) {
							continue;
						}
						queue.add(new Pos(x, y, cur.cnt + 1, 1));
						visited[1][y][x] = true;
					}
				} else {
					visited[cur.z][y][x] = true;
					queue.add(new Pos(x, y, cur.cnt + 1, cur.z));
				}
			}
		}

		System.out.println(answer);
	}


	/**
	 * 백트래킹 문제
	 */

	static boolean isMovable(int x, int y) {
		return x >= 0 && y >= 0 && x < M && y < N;
	}

	static class Pos {

		int x;
		int y;
		int cnt;
		int z;

		public Pos(int x, int y, int cnt, int z) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.z = z;
		}
	}
}