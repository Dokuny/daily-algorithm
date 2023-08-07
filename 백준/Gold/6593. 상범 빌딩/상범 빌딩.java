import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] dirs = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken()); // 층 수
            int R = Integer.parseInt(st.nextToken()); // 행
            int C = Integer.parseInt(st.nextToken()); // 열

            if(L == 0 && R == 0 && C == 0) break;

            char[][][] building = new char[L][R][C];

            Pos start = null;

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String input = br.readLine();
                    for (int k = 0; k < C; k++) {
                        char c = input.charAt(k);
                        building[i][j][k] = c;
                        if (c == 'S') {
                            start = new Pos(k, j, i, 0);
                        }
                    }
                }
                br.readLine();
            }

            // 여기서부터 로직작성 - bfs
            Queue<Pos> queue = new ArrayDeque<>();

            queue.add(start);

            int time = -1;

            while (!queue.isEmpty()) {
                Pos cur = queue.poll();

                // 방문한 위치라면 pass
                if(building[cur.z][cur.y][cur.x] == 'X') continue;

                // 출구에 도착했으면
                if (building[cur.z][cur.y][cur.x] == 'E') {
                    time = cur.time;
                    break;
                }
                // 현재 위치 방문 처리
                building[cur.z][cur.y][cur.x] = 'X';

                // 현재 위치에서 6방탐색하기
                for (int[] dir : dirs) {
                    int mX = cur.x + dir[0];
                    int mY = cur.y + dir[1];
                    int mZ = cur.z + dir[2];

                    if(mX < 0 || mX >= C) continue;
                    if(mY < 0 || mY >= R) continue;
                    if(mZ < 0 || mZ >= L) continue;
                    if(building[mZ][mY][mX] == 'X' || building[mZ][mY][mX] == '#') continue;

                    queue.add(new Pos(mX, mY, mZ, cur.time + 1));
                }
            }

            if (time != -1) {
                sb.append("Escaped in ").append(time).append(" minute(s).")
                        .append("\n");
            } else {
                sb.append("Trapped!").append("\n");
            }

        }

        System.out.println(sb);
    }


    static class Pos {
        int x;
        int y;
        int z;
        int time;

        public Pos(int x, int y, int z, int time) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.time = time;
        }

    }

}
