import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Pos> queue = new ArrayDeque<>();

		int answer = Integer.MIN_VALUE;

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					continue;
				}

				int div = 1;
				map[i][j] = 0;
				queue.add(new Pos(j, i));

				while (!queue.isEmpty()) {
					Pos cur = queue.poll();

					for (int[] dir : dirs) {
						int mx = dir[0] + cur.x;
						int my = dir[1] + cur.y;

						if(mx < 0 || my < 0 || mx >= M || my >= N) continue;
						if(map[my][mx] == 0) continue;

						div++;
						map[my][mx] = 0;
						queue.add(new Pos(mx, my));
					}
				}

				cnt++;
				answer = Math.max(div, answer);
			}

		}
		
		if(cnt==0) answer = 0;
		System.out.println(cnt+"\n"+answer);

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