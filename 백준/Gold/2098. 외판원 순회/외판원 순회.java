import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[][] dp;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 비트마스킹 이용 , [방문 마을][방문한 마을]
        dp = new int[N][(int) Math.pow(2, N)];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // 첫번째 집부터 출발 (어차피 순환되면 최적임)
        dp[0][1] = 0;

        // 도시 방문 경우의 수
        for (int visited = 1; visited < 1 << N; visited++) {
            // 현재 도시
            for (int curCity = 0; curCity < N; curCity++) {
                // 방문하지 않은 도시라면 건너뛰기
                if ((visited & (1 << curCity)) == 0) continue;
                if (dp[curCity][visited] == Integer.MAX_VALUE) continue;

                // 가야할 도시
                for (int nextCity = 0; nextCity < N; nextCity++) {
                    if (map[curCity][nextCity] == 0) continue;

                    // 방문한 도시라면
                    if ((visited & (1 << nextCity)) != 0) continue;

                    // 방문처리하고
                    int newVisited = visited | (1 << nextCity);

                    // 기존 방문 값과
                    dp[nextCity][newVisited] =
                            Math.min(dp[nextCity][newVisited], dp[curCity][visited] + map[curCity][nextCity]);
                }
            }
        }

        int result = Integer.MAX_VALUE;

        for (int i = 1; i < N; i++) {
            if (map[i][0] == 0) continue;
            if(dp[i][(1<<N)-1] == Integer.MAX_VALUE) continue;
            result = Math.min(result, dp[i][(1 << N) - 1] + map[i][0]);
        }

        System.out.println(result);
    }


}
