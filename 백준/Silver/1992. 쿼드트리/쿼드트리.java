import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] dirs = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    static int N;
    static String[][] video;
    static StringBuilder sb;

    // 분할정복 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        video = new String[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                video[i][j] = String.valueOf(input.charAt(j));
            }
        }
        sb = new StringBuilder();

        String recur = recur(0, 0, N);
        System.out.println(recur);

    }

    public static String recur(int x, int y, int size) {
        if (size == 1) {
            return String.valueOf(video[y][x]);
        }

        int half = size / 2;

        String first = recur(x, y, size / 2);
        String second = recur(x + half, y, size / 2);
        String third = recur(x, y + half, size / 2);
        String fourth = recur(x + half, y + half, size / 2);

        if (first.length() == 1 && first.equals(second) && second.equals(third) && third.equals(fourth)) {
            return first;
        } else {
            return "(" + first + second + third + fourth + ")";
        }

    }


}
