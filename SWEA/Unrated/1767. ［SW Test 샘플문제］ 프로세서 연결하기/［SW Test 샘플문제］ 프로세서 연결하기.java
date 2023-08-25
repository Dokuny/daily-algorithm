import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {

	static int[][] map;
	static int N;
	static ArrayList<Core> cores;
	static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	static int minWire;
	static int maxCore;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {

			// 가로 세로 크기
			N = Integer.parseInt(br.readLine());

			// 맵 초기화
			map = new int[N][N];

			// 코어들
			cores = new ArrayList<>();

			maxCore = Integer.MIN_VALUE;
			minWire = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						cores.add(new Core(j, i));
					}
				}
			}

			// 코어의 개수는 1 ~ 12
			dfs(0, 0, 0);

			sb.append("#").append(test_case).append(" ").append(minWire).append("\n");
		}
		System.out.println(sb);

	}


	// dfs
	static void dfs(int depth, int wire, int connectedCoreCnt) {
		if (depth == cores.size()) {
			// 코어가 우선
			if(connectedCoreCnt < maxCore) return;

			if (connectedCoreCnt == maxCore) {
				minWire = Math.min(minWire, wire);
			} else {
				minWire = wire;
				maxCore = connectedCoreCnt;
			}

			return;
		}
		// 남은 코어개수 + 연결된 코어 개수가 MaxCores 보다 작으면 더이상 할 필요 X
		if(cores.size() - depth + connectedCoreCnt < maxCore) return;

		// 현재 코어 가져오기
		Core core = cores.get(depth);
		if (core.x == 0 || core.y == 0 || core.x == N - 1 || core.y == N - 1) {
			dfs(depth + 1, wire, connectedCoreCnt + 1);
			return;
		}

		// 상하좌우 전선연결 해보기
		for (int[] dir : dirs) {

			int x = core.x;
			int y = core.y;

			// 새로 연결되는 와이어 개수
			int cnt = 0;

			// 연결되는지 체크
			boolean isWired = true;

			// 전선 연결
			while (true) {
				x += dir[0];
				y += dir[1];

				// 끝에 도달하면 종료
				if (!isMovable(x, y)) {
					break;
				}

				if (map[y][x] == 1 || map[y][x] == -1) {
					isWired = false;
					break;
				}

				map[y][x] = -1;
				cnt++;
			}

			if (isWired) {
				dfs(depth + 1, wire + cnt, connectedCoreCnt + 1);
			}

			x = core.x;
			y = core.y;

			while (cnt != 0) {
				x += dir[0];
				y += dir[1];

				map[y][x] = 0;
				cnt--;
			}

			if (!isWired) {
				dfs(depth + 1, wire, connectedCoreCnt);
			}
		}

	}

	static boolean isMovable(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

	static class Core {

		int x;
		int y;

		public Core(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}