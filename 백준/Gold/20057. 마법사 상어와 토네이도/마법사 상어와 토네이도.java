import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] map;
    static int N;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        ans = 0;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = N / 2;
        int y = N / 2;

        int move = 1;
        int direction = 0;
        int cnt = move;
        int cntCheck = 0;
        // 왼쪽, 아래  / 오른쪽 , 위

        ArrayDeque<Tornado> queue = new ArrayDeque<>();

        while (true) {
            x += dirs[direction][0];
            y += dirs[direction][1];

            if (x == -1) break;

            switch (direction) {
                case 0:
                    new Tornado(x, y, 'L').spin();
                    break;
                case 1:
                    new Tornado(x, y, 'D').spin();
                    break;
                case 2:
                    new Tornado(x, y, 'R').spin();
                    break;
                case 3:
                    new Tornado(x, y, 'U').spin();
                    break;
            }

            // 이쪽 부분 에러
            cnt--;
            if (cnt == 0) {
                direction = (direction + 1) % 4;
                cntCheck++;
                if (cntCheck == 2) {
                    move++;
                    cntCheck = 0;
                }
                cnt = move;
            }
        }

        System.out.println(ans);
    }

    static class Tornado {
        int x;
        int y;
        char direction;

        public Tornado(int x, int y, char direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public void spin() {
            switch (direction) {
                case 'L':
                    lSpin();
                    break;
                case 'R':
                    rSpin();
                    break;
                case 'U':
                    uSpin();
                    break;
                case 'D':
                    dSpin();
                    break;
            }

        }

        private void lSpin() {

            // 10개 좌표
            ArrayList<Pos> list = new ArrayList<>();

            list.add(new Pos(x, y - 1, (int) (map[y][x] * 0.07)));
            list.add(new Pos(x, y - 2, (int) (map[y][x] * 0.02)));
            list.add(new Pos(x, y + 1, (int) (map[y][x] * 0.07)));
            list.add(new Pos(x, y + 2, (int) (map[y][x] * 0.02)));
            list.add(new Pos(x + 1, y - 1, (int) (map[y][x] * 0.01)));
            list.add(new Pos(x + 1, y + 1, (int) (map[y][x] * 0.01)));
            list.add(new Pos(x - 1, y - 1, (int) (map[y][x] * 0.1)));
            list.add(new Pos(x - 1, y + 1, (int) (map[y][x] * 0.1)));
            list.add(new Pos(x - 2, y, (int) (map[y][x] * 0.05)));
            list.add(new Pos(x - 1, y, (int) (map[y][x] * 0.55)));

            moveSand(list);
        }


        private void dSpin() {
            ArrayList<Pos> list = new ArrayList<>();

            list.add(new Pos(x - 1, y - 1, (int) (map[y][x] * 0.01)));
            list.add(new Pos(x + 1, y - 1, (int) (map[y][x] * 0.01)));
            list.add(new Pos(x - 1, y, (int) (map[y][x] * 0.07)));
            list.add(new Pos(x - 2, y, (int) (map[y][x] * 0.02)));
            list.add(new Pos(x + 1, y, (int) (map[y][x] * 0.07)));
            list.add(new Pos(x + 2, y, (int) (map[y][x] * 0.02)));
            list.add(new Pos(x - 1, y + 1, (int) (map[y][x] * 0.1)));
            list.add(new Pos(x + 1, y + 1, (int) (map[y][x] * 0.1)));
            list.add(new Pos(x, y + 2, (int) (map[y][x] * 0.05)));
            list.add(new Pos(x, y + 1, (int) (map[y][x] * 0.55)));

            moveSand(list);
        }

        private void rSpin() {
            ArrayList<Pos> list = new ArrayList<>();

            list.add(new Pos(x - 1, y - 1, (int) (map[y][x] * 0.01)));
            list.add(new Pos(x - 1, y + 1, (int) (map[y][x] * 0.01)));
            list.add(new Pos(x, y - 1, (int) (map[y][x] * 0.07)));
            list.add(new Pos(x, y - 2, (int) (map[y][x] * 0.02)));
            list.add(new Pos(x, y + 1, (int) (map[y][x] * 0.07)));
            list.add(new Pos(x, y + 2, (int) (map[y][x] * 0.02)));
            list.add(new Pos(x + 1, y - 1, (int) (map[y][x] * 0.1)));
            list.add(new Pos(x + 1, y + 1, (int) (map[y][x] * 0.1)));
            list.add(new Pos(x + 2, y, (int) (map[y][x] * 0.05)));
            list.add(new Pos(x + 1, y, (int) (map[y][x] * 0.55)));

            moveSand(list);
        }

        private void uSpin() {
            ArrayList<Pos> list = new ArrayList<>();

            list.add(new Pos(x - 1, y + 1, (int) (map[y][x] * 0.01)));
            list.add(new Pos(x + 1, y + 1, (int) (map[y][x] * 0.01)));
            list.add(new Pos(x - 1, y, (int) (map[y][x] * 0.07)));
            list.add(new Pos(x - 2, y, (int) (map[y][x] * 0.02)));
            list.add(new Pos(x + 1, y, (int) (map[y][x] * 0.07)));
            list.add(new Pos(x + 2, y, (int) (map[y][x] * 0.02)));
            list.add(new Pos(x - 1, y - 1, (int) (map[y][x] * 0.1)));
            list.add(new Pos(x + 1, y - 1, (int) (map[y][x] * 0.1)));
            list.add(new Pos(x, y - 2, (int) (map[y][x] * 0.05)));
            list.add(new Pos(x, y - 1, (int) (map[y][x] * 0.55)));

            moveSand(list);
        }


        private void moveSand(ArrayList<Pos> list) {

            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                Pos pos = list.get(i);
                sum += pos.sand;
                if (pos.x < 0 || pos.y < 0 || pos.x >= N || pos.y >= N) {
                    ans += pos.sand;
                    continue;
                }

                map[pos.y][pos.x] += pos.sand;

            }

            Pos pos = list.get(list.size() - 1);
            if (pos.x >= 0 && pos.y >= 0 && pos.x < N && pos.y < N) {
                map[pos.y][pos.x] += map[y][x] - sum;
            } else {
                ans += map[y][x] - sum;
            }
            map[y][x] = 0;
        }
    }

    static class Pos {
        int x;
        int y;
        int sand;

        public Pos(int x, int y, int sand) {
            this.x = x;
            this.y = y;
            this.sand = sand;
        }
    }


}

