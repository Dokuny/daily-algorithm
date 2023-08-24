import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 브루트 포스 + bfs
		char[][] map = new char[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '1') {
					Queue<Pos> queue = new ArrayDeque<>();

					queue.add(new Pos(j, i));
					map[i][j] = '0';

					int cnt = 1;

					while (!queue.isEmpty()) {
						Pos cur = queue.poll();

						for (int[] dir : dirs) {
							int mx = cur.x + dir[0];
							int my = cur.y + dir[1];

							if(mx < 0 || my < 0 || mx >= N || my >= N) continue;
							if(map[my][mx] == '0') continue;
							cnt++;
							map[my][mx] = '0';
							queue.add(new Pos(mx, my));
						}
					}

					pq.add(cnt);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(pq.size()).append("\n");

		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
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