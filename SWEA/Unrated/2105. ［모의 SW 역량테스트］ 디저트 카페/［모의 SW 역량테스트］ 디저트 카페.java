import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	// 우상단, 우하단, 좌하단, 좌상단
	static int[][] dirs = {{1, -1}, {1, 1}, {-1, 1}, {-1, -1}};

	static int N;
	static Pos[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());

			map = new Pos[N][N];


			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {
					map[i][j] = new Pos(j, i, Integer.parseInt(st.nextToken()));
				}
			}

			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					Pos start = map[i][j];

					// 거리 반복문
					for (int row = N - 1; row >= 1; row--) {
						for (int col = N - 1; col >= 1; col--) {
							int dessert = (col + 1) * 2 +  (row + 1) * 2 - 4;

							if (max >= dessert) {
								continue;
							}

							// 네점 구하기
							Pos rightUp = getPos(j, i, col, dirs[0]);
							if(rightUp == null) continue;
							Pos rightDown = getPos(j, i, row, dirs[1]);
							if(rightDown == null) continue;
							Pos other = getPos(rightDown.x, rightDown.y, col ,dirs[0]);
							if(other == null) continue;


							// 네점 연결
							boolean[] visited = new boolean[101];

							if (isPossible(start, rightUp, dirs[0], visited) &&
								isPossible(rightUp, other, dirs[1], visited) &&
								isPossible(other, rightDown, dirs[2], visited) &&
								isPossible(rightDown, start, dirs[3], visited)) {

								max = Math.max(max, dessert);
							}

						}
					}
				}
			}

			if(max == Integer.MIN_VALUE) max = -1;
			sb.append("#").append(test_case).append(" ").append(max).append("\n");

		}

		System.out.println(sb);

	}

	static boolean isAccessible(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	static Pos getPos(int x, int y, int dist, int[] dir) {
		int mx = x + dist * dir[0];
		int my = y + dist * dir[1];

		if (isAccessible(mx, my)) {
			return map[my][mx];
		}

		return null;
	}

	static boolean isPossible(Pos start, Pos end, int[] dir, boolean[] visited) {

		int mx = start.x;
		int my = start.y;

		while (mx != end.x && my != end.y) {
			mx += dir[0];
			my += dir[1];

			if (visited[map[my][mx].kind]) {
				return false;
			}

			visited[map[my][mx].kind] = true;
		}

		return true;
	}


	static class Pos {

		int x;
		int y;
		int kind;

		public Pos(int x, int y, int kind) {
			this.x = x;
			this.y = y;
			this.kind = kind;
		}
	}

}