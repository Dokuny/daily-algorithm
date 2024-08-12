import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) + 1;
            }
        }

        int[] split = split(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for (int i : split) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);

    }


    static int[] split(int x, int y, int size) {
        if (size == 1) {
            int[] arr = new int[3];
            arr[map[y][x]]++;
            return arr;
        }

        // 9개로 분할하고 합치기
        int splitSize = size / 3;

        int[] sum = new int[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int[] split = split(x + (splitSize * i), y + (splitSize * j), splitSize);
                sum[0] += split[0];
                sum[1] += split[1];
                sum[2] += split[2];
            }
        }

        int cnt = 0;
        int num = -1;
        for (int i = 0; i < 3; i++) {
            if (sum[i] == 0) {
                cnt++;
                continue;
            }
            num = i;
        }

        if (cnt == 2) {
            sum[num] = 1;
        }

        return sum;
    }

}
