import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {


	static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();

			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		int[][][] dp = new int[2][N][M];

		ArrayDeque<Node> queue = new ArrayDeque<>();
		queue.add(new Node(0, 0, 0, 0));

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			if (cur.x == M - 1 && cur.y == N - 1) {
				System.out.println(cur.dist + 1);
				return;
			}

			for (int[] dir : dirs) {
				int mx = dir[0] + cur.x;
				int my = dir[1] + cur.y;

				if(mx < 0 || my < 0 || mx >= M || my >= N) continue;
				if(dp[cur.breakable][my][mx] != 0) continue;

				if (map[my][mx] == 1) {
					// 부술 수 있는지
					if (cur.breakable == 0) {
						if(dp[1][my][mx] != 0) continue;

						dp[1][my][mx] = cur.dist + 1;
						queue.add(new Node(mx, my, dp[1][my][mx], 1));
					}
				}else {
					dp[cur.breakable][my][mx] = cur.dist + 1;
					queue.add(new Node(mx, my, dp[cur.breakable][my][mx], cur.breakable));
				}
			}
		}

		System.out.println(-1);


	}

	static class Node {
		int x;
		int y;
		int dist;
		int breakable;

		public Node(int x, int y, int dist, int breakable) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.breakable = breakable;
		}
	}

}

