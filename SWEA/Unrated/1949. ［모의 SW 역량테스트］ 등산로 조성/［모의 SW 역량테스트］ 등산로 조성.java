import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            // 한 변의 길이
            int N = Integer.parseInt(st.nextToken());
            // 최대 공사 깊이
            int K = Integer.parseInt(st.nextToken());

            // 지도
            int[][] map = new int[N][N];

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, map[i][j]);
                }
            }

            // 지도의 모든 경우의 수 리스트
            ArrayList<int[][]> list = new ArrayList<>();
            list.add(map); // 맨처음

            for (int i = 1; i <= K; i++) {
                for (int j = 0; j < N * N; j++) {
                    int[][] arr = new int[N][N];
                    for (int k = 0; k < N; k++) {
                        arr[k] = map[k].clone();
                    }
                    int x = j % N;
                    int y = j / N;

                    if (arr[y][x] >= i) {
                        arr[y][x] -= i;
                        list.add(arr);
                    }
                }
            }

            int answer = Integer.MIN_VALUE;

            // BFS 작성
            for (int[][] arr : list) {

                Queue<Pos> queue = new ArrayDeque<>();
                
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (max == arr[i][j]) {
                            queue.add(new Pos(j, i, 0));
                        }
                    }
                }

                if(queue.size() > 5) continue;

                while (!queue.isEmpty()) {
                    Pos cur = queue.poll();

                    // 움직인 횟수
                    int moveCnt = 0;
                    for (int[] dir : dirs) {
                        int moveX = dir[0] + cur.x;
                        int moveY = dir[1] + cur.y;

                        if(moveX < 0 || moveY < 0 || moveX >= N || moveY >= N) continue;
                        if(arr[moveY][moveX] >= arr[cur.y][cur.x]) continue;

                        queue.add(new Pos(moveX, moveY, cur.cnt + 1));
                        moveCnt++;
                    }

                    // 막다른 길이면 종료
                    if (moveCnt == 0 && answer < cur.cnt) {
                        answer = cur.cnt;
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(answer + 1).append("\n");
        }
        System.out.println(sb);
    }

    static class Pos{
        int x;
        int y;
        int cnt;

        public Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}