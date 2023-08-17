import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {


    /**
     * .	평지(전차가 들어갈 수 있다.)
     * *	벽돌로 만들어진 벽
     * #	강철로 만들어진 벽
     * -	물(전차는 들어갈 수 없다.)
     * ^	위쪽을 바라보는 전차(아래는 평지이다.)
     * v	아래쪽을 바라보는 전차(아래는 평지이다.)
     * <	왼쪽을 바라보는 전차(아래는 평지이다.)
     * >	오른쪽을 바라보는 전차(아래는 평지이다.)
     * <p>
     * <p>
     * 문자	동작
     * U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
     * D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
     * L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
     * R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
     * S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
     */
    static int H;
    static int W;
    static char[][] battleField;


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        for (int test_case = 1; test_case <= T; test_case++) {

            st = new StringTokenizer(br.readLine());

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            battleField = new char[H][W];

            for (int i = 0; i < H; i++) {
                battleField[i] = br.readLine().toCharArray();
            }


            int x = 0;
            int y = 0;

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (battleField[i][j] == '<' || battleField[i][j] == '>' || battleField[i][j] == 'v' || battleField[i][j] == '^') {
                        x = j;
                        y = i;
                        break;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());

            String input = br.readLine();

            for (int i = 0; i < input.length(); i++) {
                char oper = input.charAt(i);

                // 명령어
                switch (oper) {
                    case 'U':
                        //
                        battleField[y][x] = '^';

                        if (isMovable(x, y - 1)) {
                            battleField[y][x] = '.';
                            y -= 1;
                            battleField[y][x] = '^';
                        }
                        break;
                    case 'D':
                        battleField[y][x] = 'v';

                        if (isMovable(x, y + 1)) {
                            battleField[y][x] = '.';
                            y += 1;
                            battleField[y][x] = 'v';
                        }
                        break;
                    case 'L':
                        battleField[y][x] = '<';

                        if (isMovable(x - 1, y)) {
                            battleField[y][x] = '.';
                            x -= 1;
                            battleField[y][x] = '<';
                        }
                        break;
                    case 'R':
                        battleField[y][x] = '>';

                        if (isMovable(x + 1, y)) {
                            battleField[y][x] = '.';
                            x += 1;
                            battleField[y][x] = '>';
                        }
                        break;
                    case 'S':
                        shoot(battleField[y][x], x, y);
                        break;
                }

            }
            sb.append("#").append(test_case).append(" ");
            for (int i = 0; i < battleField.length; i++) {
                sb.append(battleField[i]).append("\n");
            }
        }
        
        System.out.println(sb);
    }

    static boolean isMovable(int x, int y) {
        if (x < 0 || y < 0 || x >= W || y >= H) return false;
        if (battleField[y][x] != '.') return false;
        return true;
    }

    static boolean isShootable(int x, int y) {
        if (x < 0 || y < 0 || x >= W || y >= H) return false;
        return true;
    }

    static void shoot(char watch, int x, int y) {

        switch (watch) {
            case '^':
                while (isShootable(x, y)) {
                    switch (battleField[y][x]) {
                        case '*':
                            battleField[y][x] = '.';
                            return;
                        case '#':
                            return;
                    }
                    y--;
                }
                break;
            case 'v':
                while (isShootable(x, y)) {
                    switch (battleField[y][x]) {
                        case '*':
                            battleField[y][x] = '.';
                            return;
                        case '#':
                            return;
                    }
                    y++;
                }
                break;
            case '<':
                while (isShootable(x, y)) {
                    switch (battleField[y][x]) {
                        case '*':
                            battleField[y][x] = '.';
                            return;
                        case '#':
                            return;
                    }
                    x--;
                }
                break;
            case '>':
                while (isShootable(x, y)) {
                    switch (battleField[y][x]) {
                        case '*':
                            battleField[y][x] = '.';
                            return;
                        case '#':
                            return;
                    }
                    x++;
                }
                break;
        }
    }
}