import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int M;
    static int N;

    static int[][] map;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[M][N];

        M -= 1;
        N -= 1;

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[M][N] = 1;
        dfs(0, 0);
        System.out.println(dp[0][0]);

    }

    public static int dfs(int x, int y) {
        if (dp[y][x] != -1) return dp[y][x];

        // 4방탐색
        dp[y][x] = 0;
        
        for (int[] dir : dirs) {
            int moveX = dir[0] + x;
            int moveY = dir[1] + y;

            if (moveX < 0 || moveY < 0 || moveX > N || moveY > M) continue;
            if (map[moveY][moveX] >= map[y][x]) continue;

            dp[y][x] += dfs(moveX, moveY);
        }

        return dp[y][x];
    }
}

