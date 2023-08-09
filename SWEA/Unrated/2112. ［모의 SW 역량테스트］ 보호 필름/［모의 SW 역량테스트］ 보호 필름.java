import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

    static int row;
    static int col;
    static int base;
    static boolean[][] map;
    static int answer;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {

            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            base = Integer.parseInt(st.nextToken());

            map = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < col; j++) {
                    map[i][j] = st.nextToken().equals("0");
                }
            }

            answer = Integer.MAX_VALUE;

            // dfs
            dfs(0, 0);

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");

        }
        System.out.println(sb);
    }

    public static void dfs(int curRow, int cnt) {
        if (cnt >= answer) return;
        if (curRow == row) {
            if (validate()) {
                answer = cnt;
            }
            
            return;
        }

        boolean[] original = map[curRow].clone();
        dfs(curRow + 1, cnt);
        Arrays.fill(map[curRow], true);
        dfs(curRow + 1, cnt + 1);
        Arrays.fill(map[curRow], false);
        dfs(curRow + 1, cnt + 1);

        map[curRow] = original;

    }

    // 검증 로직
    public static boolean validate() {
        for (int i = 0; i < col; i++) {
            boolean mark = map[0][i];
            int cnt = 0;
            for (int j = 0; j < row; j++) {
                if (mark != map[j][i]) {
                    cnt = 1;
                    mark = !mark;
                } else {
                    cnt++;
                    if (cnt >= base) {
                        break;
                    }
                }
            }

            if (cnt < base) {
                return false;
            }
        }
        return true;
    }
}