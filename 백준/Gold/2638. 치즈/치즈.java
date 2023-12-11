import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {


	static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static int N;
	static int M;
	static int[][] map;


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// bfs
		int time = 0;
		while (bfs() != 0) {
			time++;
		}
		System.out.println(time+1);
	}

	static int bfs() {
		ArrayDeque<Node> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		queue.add(new Node(0, 0));

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			for (int[] dir : dirs) {
				int mx = dir[0] + cur.x;
				int my = dir[1] + cur.y;

				if(mx < 0 || my < 0 || mx >= M || my >= N) continue;
				if(visited[my][mx]) continue;

				// 치즈인 경우
				if (map[my][mx] != 0) {
					map[my][mx]++;
				} else {
					visited[my][mx] = true;
					queue.add(new Node(mx, my));
				}
			}
		}
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					continue;
				}else if (map[i][j] >= 3) {
					map[i][j] = 0;
				}else {
					cnt++;
					map[i][j] = 1;
				}
			}
		}

		return cnt;
	}

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}

