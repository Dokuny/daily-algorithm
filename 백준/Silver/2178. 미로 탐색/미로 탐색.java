import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int N;
    static int M;
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

        Queue<Node> queue = new ArrayDeque<>();


        queue.add(new Node(0, 0, 1));
        map[0][0] = false;

        Node cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();

            if (cur.x == M - 1 && cur.y == N - 1) {
                break;
            }

            for (int[] dir : dirs) {
                int mX = cur.x + dir[0];
                int mY = cur.y + dir[1];

                if(mX < 0 || mY < 0 || mX >= M || mY >= N) continue;
                if(!map[mY][mX]) continue;

                map[mY][mX] = false;
                queue.add(new Node(mX, mY, cur.cnt + 1));
            }

        }

        System.out.println(cur.cnt);
    }

    static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }


}

