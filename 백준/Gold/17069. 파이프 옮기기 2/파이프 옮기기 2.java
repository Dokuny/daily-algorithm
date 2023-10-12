import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


	// 0번 가로 ,1번 세로, 2번 대각선
	static int[][][] dirs = {{{1, 0, 0}, {1, 1, 2}}, {{0, 1, 1}, {1, 1, 2}},
		{{1, 0, 0}, {0, 1, 1}, {1, 1, 2}}};

	static int[][] map;
	static long[][][] dp;
	static int N;
	static int end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		end = N - 1;

		map = new int[N][N];
		dp = new long[N][N][3];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dfs(1, 0, 0));
		int test = 0;
	}

	static long dfs(int x, int y, int curDir) {
		// 끝에 도달하면 탈출
		if (x == end && y == end) {
			return 1;
		}

		if (dp[y][x][curDir] != 0) {
			return dp[y][x][curDir];
		}

		long sum = 0;

		// 현재 방향에서 이동하기
		for (int[] ableDir : dirs[curDir]) {
			int mx = x + ableDir[0];
			int my = y + ableDir[1];

			if (!isMovable(mx, my , ableDir[2])) {
				continue;
			}

			// 방문한 곳인지 파악 - 현재 방향에서 갈 수 있는 DP에 값이 있는지 확인
			sum += dfs(mx, my, ableDir[2]);
		}

		dp[y][x][curDir] = sum;

		return dp[y][x][curDir];
	}

	static boolean isMovable(int x, int y , int dir) {

		if(x < 0 || y < 0 || x >= N || y >= N) return false;

		if(map[y][x] == 1) return false;

		// 대각선일 때, 주변에 벽이 없어야 함
		if (dir == 2) {
			int up = map[y - 1][x];
			int down = map[y][x - 1];

			if (up == 1 || down == 1) {
				return false;
			}
		}

		return true;
	}

}
