import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int N;
	static int W;
	static int H;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;

		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			int[][] map = new int[H][W];
			int[] top = new int[W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 0) {
						if (i + 1 >= H) {
							top[j] = H - 1;
						} else {
							top[j] = i + 1;
						}
					}
				}
			}

			answer = Integer.MAX_VALUE;
			// 맨위 돌면서 dfs
			dfs(0, map, top);

			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);

	}

	static void dfs(int depth, int[][] map, int[] top) {
		// 벽돌을 다 사용하면
		if (depth == N) {

			// 벽돌 개수 체크
			int cnt = 0;

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] != 0) {
						cnt++;
					}
				}
			}

			answer = Math.min(cnt, answer);
			return;
		}

		Queue<Node> queue;

		for (int i = 0; i < W; i++) {

			int[] newTop = top.clone();

			int[][] newMap = new int[H][W];
			for (int j = 0; j < H; j++) {
				newMap[j] = map[j].clone();
			}

			queue = new ArrayDeque<>();

			int x = i;
			int y = newTop[i];

			queue.add(new Node(x, y, newMap[y][x]));
			newMap[y][x] = 0;

			while (!queue.isEmpty()) {
				Node cur = queue.poll();

				int power = cur.power;

				for (int[] dir : dirs) {
					int mx = cur.x;
					int my = cur.y;

					for (int j = 0; j < power; j++) {
						mx += dir[0];
						my += dir[1];

						if (mx < 0 || my < 0 || mx >= W || my >= H) {
							continue;
						}
						if (newMap[my][mx] == 0) {
							continue;
						}

						queue.add(new Node(mx, my, newMap[my][mx]));
						newMap[my][mx] = 0;

					}
				}
			}

			applyGravity(newMap, newTop);

			dfs(depth + 1, newMap, newTop);
		}

	}


	// 맵 중력 적용
	static void applyGravity(int[][] map, int[] top) {

		// 열을 돌면서 중력 적용
		for (int i = 0; i < W; i++) {

			int idx = H - 1;

			// 오류 발생
			for (int j = H - 1; j >= 0; j--) {
				if (map[j][i] != 0) {
					int temp = map[j][i];
					map[j][i] = 0;
					top[i] = idx;
					map[idx--][i] = temp;
				}
			}
		}

	}

	static class Node {

		int x;
		int y;
		int power;

		public Node(int x, int y, int power) {
			this.x = x;
			this.y = y;
			this.power = power - 1;
		}
	}
}