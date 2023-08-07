import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N * 2 - 1];

        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], ' ');
        }

        recur(map[0].length/2, 0, N);


        for (char[] stars : map) {
            bw.write(stars);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
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
        map[y][x] = '*';
        map[y + 1][x - 1] = '*';
        map[y + 1][x + 1] = '*';

        for (int i = x - 2; i <= x + 2; i++) {
            map[y + 2][i] = '*';
        }
    }
}
