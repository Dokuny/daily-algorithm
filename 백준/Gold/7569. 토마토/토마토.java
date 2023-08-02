import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 23.08.02
 */
public class Main {

	static int[][] dirs = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][][] boxes = new int[H][N][M];

		int tomato = 0;

		ArrayDeque<Tomato> queue = new ArrayDeque<>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					boxes[i][j][k] = Integer.parseInt(st.nextToken());

					if (boxes[i][j][k] == 1) {
						queue.add(new Tomato(k, j, i, 0));
					}

					if(boxes[i][j][k] == 0) tomato++;
				}
			}
		}

		if (tomato == 0) {
			System.out.println(0);
			return;
		}

		Tomato cur = null;
		while (!queue.isEmpty()) {

			cur = queue.poll();

			for (int[] dir : dirs) {
				int moveX = cur.x + dir[0];
				int moveY = cur.y + dir[1];
				int moveZ = cur.z + dir[2];

				if (moveX < 0 || moveY < 0 || moveZ < 0 || moveX >= M || moveY >= N || moveZ >= H) {
					continue;
				}

				if(boxes[moveZ][moveY][moveX] != 0) continue;

				boxes[moveZ][moveY][moveX] = 1;

				queue.add(new Tomato(moveX, moveY, moveZ, cur.day + 1));
				tomato--;
			}
		}

		if (cur == null || tomato != 0) {
			System.out.println(-1);
		} else {
			System.out.println(cur.day);
		}
	}

	static class Tomato {
		int x;
		int y;
		int z;
		int day;

		public Tomato(int x, int y, int z, int day) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.day = day;
		}
	}


}
