import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][C];

		Pos start = null;
		Pos end = null;

		Queue<Pos> waterQueue = new ArrayDeque<>();

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);

				if (map[i][j] == 'S') {
					start = new Pos(j, i, 0);
				}

				if (map[i][j] == 'D') {
					end = new Pos(j, i, 0);
				}

				if (map[i][j] == '*') {
					waterQueue.add(new Pos(j, i, 0));
				}
			}
		}

		Queue<Pos> bieberQueue = new ArrayDeque<>();
		bieberQueue.add(start);
		map[start.y][start.x] = '0';

		String answer = "KAKTUS";
		while (!bieberQueue.isEmpty()) {

			// 물 증가 시키기
			int size = waterQueue.size();
			for (int i = 0; i < size; i++) {
				Pos water = waterQueue.poll();

				for (int[] dir : dirs) {
					int mx = dir[0] + water.x;
					int my = dir[1] + water.y;

					if (mx < 0 || my < 0 || mx >= C || my >= R) {
						continue;
					}
					if (map[my][mx] == '*' || map[my][mx] == 'X' || map[my][mx] == 'D') {
						continue;
					}

					map[my][mx] = '*';

					waterQueue.add(new Pos(mx, my, 0));
				}
			}

			// 비버 이동하기
			int bieberSize = bieberQueue.size();

			for (int i = 0; i < bieberSize; i++) {
				Pos bieber = bieberQueue.poll();

				for (int[] dir : dirs) {
					int mx = dir[0] + bieber.x;
					int my = dir[1] + bieber.y;

					if (mx < 0 || my < 0 || mx >= C || my >= R) {
						continue;
					}
					if (map[my][mx] == 'D') {
						System.out.println(bieber.cnt+1);
						return;
					}
					if (map[my][mx] != '.') {
						continue;
					}

					map[my][mx] = '0';

					bieberQueue.add(new Pos(mx, my, bieber.cnt + 1));
				}
			}



		}
		System.out.println(answer);
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
