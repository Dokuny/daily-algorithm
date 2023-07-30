import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 23.07.30
 */
public class Main {

	static int[] moveX = {1, -1, 0, 0};
	static int[] moveY = {0, 0, 1, -1};


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] box = new int[M][N];

		// BFS를 위한 Queue
		Queue<Cell> queue = new LinkedList<>();

		int baby = N * M;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());

				// 익은 토마토들부터 BFS를 시작해야하므로 넣어주기
				if (box[i][j] == 1) {
					queue.add(new Cell(j, i));
				}

				if (box[i][j] != 0) {
					baby--;
				}
			}
		}

		Cell cur = new Cell(0, 0);

		while (!queue.isEmpty()) {
			// 토마토 꺼내오기
			cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				// 이동할 상자 계산
				int nextX = cur.x + moveX[i];
				int nextY = cur.y + moveY[i];

				// 상자 밖을 벗어나는지 확인
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
					continue;
				}
				// 상태가 좋은 토마토인지 확인
				if (box[nextY][nextX] != 0) {
					continue;
				}

				// 토마토 완숙 처리
				box[nextY][nextX] = box[cur.y][cur.x] + 1;
				// 완숙 토마토 큐에 집어넣기
				queue.add(new Cell(nextX, nextY));
				baby--;
			}
		}

		if (baby != 0) {
			System.out.println(-1);
		} else {
			System.out.println(box[cur.y][cur.x] - 1);
		}
	}

	static class Cell {

		int x;
		int y;

		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
