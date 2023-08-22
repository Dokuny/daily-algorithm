import com.sun.org.apache.xpath.internal.operations.Neg;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int[][] dist = new int[N][M];

		Pos start = null;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					start = new Pos(j, i, 0);
				}
			}
		}

		Queue<Pos> queue = new ArrayDeque<>();
		dist[start.y][start.x] = 0;
		map[start.y][start.x] = 0;
		queue.add(start);

		while (!queue.isEmpty()) {
			Pos cur = queue.poll();

			for (int[] dir : dirs) {
				int mx = cur.x + dir[0];
				int my = cur.y + dir[1];

				if (mx < 0 || my < 0 || mx >= M || my >= N) {
					continue;
				}

				if (map[my][mx] == 0) {
					continue;
				}
				map[my][mx] = 0;
				dist[my][mx] = cur.cnt + 1;

				queue.add(new Pos(mx, my, cur.cnt + 1));
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && dist[i][j] == 0) {
					sb.append("-1").append(" ");
				} else {
					sb.append(dist[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static class Pos {

		int x;
		int y;
		int cnt;


		public Pos(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}


}