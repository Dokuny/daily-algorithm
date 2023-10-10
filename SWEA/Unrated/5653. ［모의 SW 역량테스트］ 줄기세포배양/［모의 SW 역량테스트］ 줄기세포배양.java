import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			Cell[][] map = new Cell[N + K * 2][M + K * 2];

			Queue<Cell>[] activateQueue = new Queue[2 * K + 1];

			for (int i = 1; i < activateQueue.length; i++) {
				activateQueue[i] = new ArrayDeque<>();
			}

			for (int i = K; i < K + N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = K; j < K + M; j++) {
					int life = Integer.parseInt(st.nextToken());

					if (life != 0) {
						Cell cell = new Cell(j, i, life, 0);
						map[i][j] = cell;
						activateQueue[cell.activatedAt].add(cell);
					}
				}
			}

			int time = 1;

			while (time < K) {
				// 번식하기
				while (!activateQueue[time].isEmpty()) {
					Cell cur = activateQueue[time].poll();

					if (map[cur.y][cur.x] != cur) {
						continue;
					}

					for (int[] dir : dirs) {
						int mx = cur.x + dir[0];
						int my = cur.y + dir[1];

						if (mx < 0 || my < 0 || mx >= map[0].length || my >= map.length) {
							continue;
						}

						// 해당 칸에 이미 세포가 있는 경우
						if (map[my][mx] != null) {
							Cell other = map[my][mx];
							if (other.createdAt == time+1) {
								if (cur.life > other.life) {
									Cell cell = new Cell(mx, my, cur.life, time+1);
									map[my][mx] = cell;
									activateQueue[cell.activatedAt].add(cell);
								}
							}
							continue;
						}

						Cell cell = new Cell(mx, my, cur.life, time + 1);
						map[my][mx] = cell;
						activateQueue[cell.activatedAt].add(cell);
					}
				}

				time++;
			}

			int answer = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if (map[i][j] != null) {
						if (map[i][j].deletedAt > K && map[i][j].createdAt <= K) {
							answer++;
						}
					}
				}
			}

			sb.append("#").append(test_case).append(" ").append(answer).append("\n");

		}
		System.out.println(sb);
	}

	static class Cell {

		int x;
		int y;

		// 생명력 수치
		int life;

		// 생성 시간
		int createdAt;

		// 활성 시작 시간
		int activatedAt;

		// 사망 시간
		int deletedAt;

		public Cell(int x, int y, int life, int createdAt) {
			this.x = x;
			this.y = y;
			this.life = life;
			this.createdAt = createdAt;
			this.activatedAt = this.createdAt + life;
			this.deletedAt = this.activatedAt + life;
		}
	}

}