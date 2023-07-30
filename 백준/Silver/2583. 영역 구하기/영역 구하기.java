import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 23.07.30
 */
public class Main {

	static int[] moveX = {1, -1, 0, 0};
	static int[] moveY = {0, 0, 1, -1};

	static int N;
	static int M;

	static boolean[][] paper;
	static ArrayList<Integer> list;




	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		paper = new boolean[N][M];
		list = new ArrayList<>();

		for (int i = 0; i < K; i++) {

			st = new StringTokenizer(br.readLine());

			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());

			for (int j = startX; j < endX; j++) {
				for (int k = startY; k < endY; k++) {
					paper[k][j] = true;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(paper[i][j]) continue;
				bfs(j, i);
			}
		}

		Collections.sort(list);

		StringBuilder sb = new StringBuilder();

		sb.append(list.size()).append("\n");

		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();

		int area = 1;

		queue.add(new int[]{x, y});
		paper[y][x] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = cur[0] + moveX[i];
				int nextY = cur[1] + moveY[i];

				if (nextY < 0 || nextX < 0 || nextX >= M || nextY >= N) {
					continue;
				}

				if(paper[nextY][nextX]) continue;

				paper[nextY][nextX] = true;
				area++;

				queue.add(new int[]{nextX, nextY});
			}
		}

		list.add(area);

	}

}
