import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int N;
    static int M;
    static int[][] dp;
    static boolean[][] map;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == '1') {
                    map[i][j] = true;
                }
            }
        }

        dp = new int[N][M];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dfs(0, 0, 1);
        System.out.println(dp[N - 1][M - 1]);
    }

    public static void dfs(int x, int y, int cnt) {
        if (dp[y][x] <= cnt) return;

        dp[y][x] = Math.min(cnt, dp[y][x]);

        for (int[] dir : dirs) {
            int mX = x + dir[0];
            int mY = y + dir[1];

            if (mX < 0 || mY < 0 || mX >= M || mY >= N) continue;
            if (!map[mY][mX]) continue;
            if (dp[mY][mX] <= cnt + 1) continue;

            dfs(mX, mY, cnt + 1);
        }

    }


}

