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
					queue.add(new Cell(j, i, 0));
				}

				if(box[i][j] != 0) baby--;
			}
		}

		int depth = 0;
		while (!queue.isEmpty()) {
			// 토마토 꺼내오기
			Cell cur = queue.poll();


			for (int i = 0; i < 4; i++) {
				// 이동할 상자 계싼
				int nextX = cur.x + moveX[i];
				int nextY = cur.y + moveY[i];

				// 상자 밖을 벗어나는지 확인
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
				// 상태가 좋은 토마토인지 확인
				if (box[nextY][nextX] != 0) continue;

				// 토마토 완숙 처리
				box[nextY][nextX] = 1;
				// bfs 깊이 체크
				depth = Math.max(depth, cur.depth + 1);
				// 완숙 토마토 큐에 집어넣기
				queue.add(new Cell(cur.x + moveX[i], cur.y + moveY[i], cur.depth + 1));
				baby--;
			}
		}

		if (baby != 0) {
			System.out.println(-1);
		} else {
			System.out.println(depth);
		}
	}

	static class Cell {

		int x;
		int y;
		int depth;

		public Cell(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}

}
