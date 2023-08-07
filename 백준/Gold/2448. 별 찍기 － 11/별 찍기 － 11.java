import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N * 2 - 1];

        recur(map[0].length/2, 0, N);

        StringBuilder sb = new StringBuilder();

        for (boolean[] stars : map) {
            for (boolean star : stars) {
                sb.append(star ? '*' : ' ');
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static void recur(int x, int y, int size) {
        if (size == 3) {
            star(x,y);
            return;
        }
        // 기준점을 기준으로 세점 쪼개기
        int leftY = y + size / 2;
        int rightY = leftY;
        int leftX = x - size / 2;
        int rightX = x + size / 2;

        int newSize = size / 2;
        recur(x, y, newSize);
        recur(leftX, leftY, newSize);
        recur(rightX, rightY,  newSize);
    }

    public static void star(int x, int y) {
        map[y][x] = true;
        map[y + 1][x - 1] = true;
        map[y + 1][x + 1] = true;

        for (int i = x - 2; i <= x + 2; i++) {
            map[y + 2][i] = true;
        }
    }
}
