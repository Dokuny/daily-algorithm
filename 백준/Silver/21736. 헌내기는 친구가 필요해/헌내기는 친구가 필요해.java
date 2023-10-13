import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
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

		char[][] map = new char[N][M];

		Pos start = null;
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);

				if (map[i][j] == 'I') {
					start = new Pos(j, i);
				}

			}
		}

		Queue<Pos> queue = new ArrayDeque<>();
		queue.add(start);

		int cnt = 0;

		map[start.y][start.x] = 'X';

		while (!queue.isEmpty()) {
			Pos cur = queue.poll();

			for (int[] dir : dirs) {
				int mx = cur.x + dir[0];
				int my = cur.y + dir[1];

				if(mx < 0 || my < 0 || mx >= M || my >= N) continue;
				if(map[my][mx] == 'X') continue;

				if(map[my][mx] == 'P') cnt++;

				map[my][mx] = 'X';
				queue.add(new Pos(mx, my));
			}
		}

		System.out.println(cnt == 0 ? "TT" : cnt);
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
