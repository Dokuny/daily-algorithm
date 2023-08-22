import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int[] count;
	static boolean[][] paper;
	static int[][] dp;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		paper = new boolean[10][10];
		count = new int[6];
		dp = new int[10][10];

		StringTokenizer st;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				paper[i][j] = st.nextToken().equals("1");
			}
		}

		// 최대 값 찾아서 색종이 붙이기
		dfs();

		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	// 백트래킹
	static void dfs() {
		renewDp();

		for (int n : count) {
			if (n > 5) {
				return;
			}
		}

		int cnt = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (dp[i][j] > 0) {
					for (int k = dp[i][j]; k >= 1; k--) {
						stick(j, i, k);
						count[k]++;
						dfs();
						count[k]--;
						stickReverse(j, i, k);
					}
					cnt++;
					return;
				}
			}
		}

		if (cnt == 0) {
			int sum = 0;
			for (int i : count) {
				sum += i;
			}

			answer = Math.min(answer, sum);
		}
	}


	static void renewDp() {
		dp = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (!paper[i][j]) {
					continue;
				}
				dp[i][j] = check(j, i);
			}
		}
	}

	static void stick(int x, int y, int size) {
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				paper[i][j] = false;
			}
		}
	}

	static void stickReverse(int x, int y, int size) {
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				paper[i][j] = true;
			}
		}
	}

	static int check(int x, int y) {
		// 4개 종류의 색종이를 하나씩 붙여보기
		// 5사이즈 부터
		boolean isPossible;
		for (int i = 5; i >= 2; i--) {
			isPossible = true;
			for (int j = y; j < y + i; j++) {
				for (int k = x; k < x + i; k++) {
					if (!isMovable(k, j) || !paper[j][k]) {
						isPossible = false;
						break;
					}
				}

				if (!isPossible) {
					break;
				}
			}
			if (isPossible) {
				return i;
			}
		}
		return 1;
	}

	static void stickOne() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (count[1] > 5) {
					System.out.println("-1");
					return;
				}
				if (paper[i][j]) {
					// 4방탐색
					int cnt = 0;

					for (int[] dir : dirs) {
						int mx = j + dir[0];
						int my = i + dir[1];
						if (!isMovable(mx, my)) {
							continue;
						}
						if (!paper[my][mx]) {
							cnt++;
						}
					}
					if (cnt == 3 || cnt == 4) {
						paper[i][j] = false;
						count[1]++;
					}
				}
			}
		}
	}

	static boolean isMovable(int x, int y) {
		if (x < 0 || y < 0 || x >= 10 || y >= 10) {
			return false;
		}
		return true;
	}
}