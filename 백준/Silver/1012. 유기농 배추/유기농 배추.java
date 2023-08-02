import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 23.07.30
 */
public class Main {

	static int T;
	static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());

			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[][] ground = new int[N][M];

			ArrayDeque<Node> queue = new ArrayDeque<>();
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				ground[y][x] = 1;
				queue.add(new Node(x, y));
			}
			int cnt = 0;

			while (!queue.isEmpty()) {
				Node cur = queue.poll();
				if(ground[cur.y][cur.x] == 0) continue;

				ArrayDeque<Node> stack = new ArrayDeque<>();
				stack.add(cur);

				while (!stack.isEmpty()) {
					Node dfsCur = stack.pollLast();

					ground[dfsCur.y][dfsCur.x] = 0;

					for (int[] dir : dirs) {
						int moveX = dfsCur.x + dir[0];
						int moveY = dfsCur.y + dir[1];

						if (moveX < 0 || moveX >= M || moveY < 0 || moveY >= N
							|| ground[moveY][moveX] == 0) {
							continue;
						}

						stack.add(new Node(moveX, moveY));
					}
				}

				cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
		
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
