import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static int N;
	static int M;


	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		ArrayList<Glacier> glaciers = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				glaciers.add(new Glacier(j, i, map[i][j]));
			}
		}

		int year = 0;

		Glacier start = null;

		while (true) {
			year++;
			// 빙하 돌면서 감소시키기
			// 빙하를 리스트에서 삭제시키지 않고 그냥 통과만 시킴 - 후에 리스트 삭제할 때 속도와 비교 필요

			int exist = 0;
			for (Glacier glacier : glaciers) {
				if(glacier.h == 0) continue;
				int sea = 0;

				for (int[] dir : dirs) {
					int mx = glacier.x + dir[0];
					int my = glacier.y + dir[1];

					if (!isMovable(mx, my)) {
						continue;
					}
					if(map[my][mx] == 0) sea++;
				}

				if (glacier.h <= sea) {
					glacier.h = 0;
				} else {
					glacier.h -= sea;
					start = glacier;
					exist++;
				}
			}

			// 맵에 적용하기
			for (Glacier glacier : glaciers) {
				if(map[glacier.y][glacier.x] == 0) continue;
				map[glacier.y][glacier.x] = glacier.h;
			}
//			int idx = 0;
//			while (idx < glaciers.size()) {
//				Glacier glacier = glaciers.get(idx);
//
//				map[glacier.y][glacier.x] = glacier.h;
//
//				if (glacier.h == 0) {
//					glaciers.remove(idx);
//					continue;
//				}
//				idx++;
//			}

			if (exist == 0) {
				System.out.println(0);
				return;
			}

			// 빙산 하나 잡고 bfs 돌려보고 list 크기만큼 안나오면 빙하 분리

			boolean[][] visited = new boolean[N][M];
			Queue<Glacier> queue = new ArrayDeque<>();
			queue.add(start);
			visited[start.y][start.x] = true;

			int cnt = 0;
			while (!queue.isEmpty()) {
				Glacier cur = queue.poll();

				cnt++;
				for (int[] dir : dirs) {
					int mx = cur.x + dir[0];
					int my = cur.y + dir[1];

					if(!isMovable(mx,my)) continue;
					if(map[my][mx] == 0) continue;
					if(visited[my][mx]) continue;

					visited[my][mx] = true;
					queue.add(new Glacier(mx, my, 0));
				}
			}

			if (cnt != exist) {
				System.out.println(year);
				return;
			}
		}
	}

	static boolean isMovable(int x, int y) {
		return x >= 0 && y >= 0 && x < M && y < N;
	}

	static class Glacier {
		int x;
		int y;
		int h;

		public Glacier(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}


}