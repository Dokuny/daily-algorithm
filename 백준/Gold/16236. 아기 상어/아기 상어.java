import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];

		StringTokenizer st;

		Shark shark = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 9) {
					shark = new Shark(j, i, 2, 0);
					map[i][j] = 0;
				}
			}
		}

		int time = 0;
		while (true) {
			int tempTime = time;

			Node[][] visited = new Node[N][N];
			// BFS 돌려서 갈 수 있는 범위 체크
			Queue<Node> queue = new ArrayDeque<>();
			queue.add(new Node(shark.x, shark.y, 0));
			visited[shark.y][shark.x] = new Node(shark.x, shark.y, 0);


			int cnt = 0;
			while (!queue.isEmpty()) {
				int size = queue.size();

				for (int i = 0; i < size; i++) {
					Node cur = queue.poll();

					for (int[] dir : DIRS) {
						int mx = dir[0] + cur.x;
						int my = dir[1] + cur.y;

						if(mx < 0 || my < 0 || mx >= N || my >= N) continue;
						if(visited[my][mx] != null) continue;
						if(map[my][mx] > shark.size) continue;

						visited[my][mx] = new Node(mx, my, cur.time + 1);

						if (map[my][mx] < shark.size && map[my][mx] > 0) {
							cnt++;
						}

						queue.add(visited[my][mx]);
					}
				}

				if (cnt != 0) {
					boolean isArrived = false;
					for (int i = 0; i < N; i++) {
						if(isArrived) break;
						for (int j = 0; j < N; j++) {

							if (visited[i][j] != null && map[i][j] > 0 && map[i][j] < shark.size) {
								shark.x = j;
								shark.y = i;
								shark.eatCnt++;
								if (shark.eatCnt == shark.size) {
									shark.eatCnt = 0;
									shark.size++;
								}

								map[i][j] = 0;

								time += visited[i][j].time;

								isArrived = true;
								queue.clear();
								break;
							}

						}

					}
				}
			}

			if (tempTime == time) {
				System.out.println(time);
				return;
			}

		}




	}
	static class Node {
		int x;
		int y;
		int time;

		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	static class Shark {
		int x;
		int y;
		int size;
		int eatCnt;

		public Shark(int x, int y, int size, int eatCnt) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.eatCnt = eatCnt;
		}
	}
}