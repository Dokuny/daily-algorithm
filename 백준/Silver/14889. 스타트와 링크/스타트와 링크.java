import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int teamSize;
    static int[][] map;
    static boolean[] visited;
    static int[] team;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        teamSize = N/2;

        map = new int[N][N];
        visited = new boolean[N];
        team = new int[teamSize];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 0);

        System.out.println(min);

    }

    // 애초에 한쪽을 구하면 반대쪽이 나오기 때문에 전부 다 돌 필요가 없음
    // 0 기준 조합만 구하면 다 나온다.

    // 조합
    public static void dfs(int depth, int player) {
        // 팀원은 전체 인원의 절반
        if (depth == teamSize) {
            int teamA = 0;
            int teamB = 0;
            visited[player] = true;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i] && visited[j]) {
                        teamA += map[i][j];
                    } else if (!visited[i] && !visited[j]) {
                        teamB += map[i][j];
                    }
                }
            }
            visited[player] = false;

            min = Math.min(min, Math.abs(teamA - teamB));
            return;
        }

        visited[player] = true;
        for (int i = player+1; i < N; i++) {
            if(visited[i]) continue;
            dfs(depth + 1, i);
        }
        visited[player] = false;
    }



}
