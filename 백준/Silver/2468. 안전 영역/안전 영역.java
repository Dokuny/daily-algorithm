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

	static int N;
	static int[][] arr;

	static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = 0;
		for (int i = 0; i <= 100; i++) {
			int num = bfs(i);
			if(num == 0) break;
			max = Math.max(max, num);
		}

		System.out.println(max);

	}

	public static int bfs(int height) {

		int cnt = 0;

		boolean[][] visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] <= height || visited[i][j]) {
					continue;
				}

				Queue<int[]> queue = new LinkedList<>();

				queue.add(new int[]{j, i});

				while (!queue.isEmpty()) {
					int[] cur = queue.poll();

					if (visited[cur[1]][cur[0]] || arr[cur[1]][cur[0]] <= height) {
						continue;
					}

					visited[cur[1]][cur[0]] = true;

					for (int k = 0; k < 4; k++) {
						int nextX = cur[0] + dirs[k][0];
						int nextY = cur[1] + dirs[k][1];

						if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
							continue;
						}

						queue.add(new int[]{nextX, nextY});
					}
				}

				cnt++;
			}
		}

		return cnt;
	}


}
