import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int R;
    static int C;
    static boolean[] visited;
    static char[][] map;

    static int answer = Integer.MIN_VALUE;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[26];

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(answer);
    }

    public static void dfs(int x, int y, int cnt) {

        int repeat = 0;

        for (int[] dir : dirs) {
            int mX = x + dir[0];
            int mY = y + dir[1];

            if (mX < 0 || mY < 0 || mX >= C || mY >= R) continue;
            if (visited[map[mY][mX] - 'A']) continue;

            visited[map[mY][mX] - 'A'] = true;
            dfs(mX, mY, cnt + 1);
            visited[map[mY][mX] - 'A'] = false;
            repeat++;
        }

        if (repeat == 0) {
            answer = Math.max(answer, cnt);
        }
    }


}

