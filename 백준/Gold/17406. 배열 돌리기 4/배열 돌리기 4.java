import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int[] order;
    static boolean[] visited;
    static int K;
    static int N;
    static int M;
    static int min;
    static int[][] oper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        order = new int[K];
        visited = new boolean[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        oper = new int[K][3];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            oper[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }



        min = Integer.MAX_VALUE;

        perm(0);

        System.out.println(min);


    }

    public static void perm(int depth) {
        if (depth == K) {
            int[][] origin = cloneArray(map);

            for (int i = 0; i < K; i++) {
                int[] ints = oper[order[i]];
                rotate(ints[0], ints[1], ints[2]);
            }

            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < M; j++) {
                    sum += map[i][j];
                }
                min = Math.min(min, sum);
            }

            map = origin;

            return;
        }

        for (int i = 0; i < K; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            order[depth] = i;
            perm(depth + 1);
            visited[i] = false;
        }

    }

    /**
     * @param r : 행 , 1번부터 시작
     * @param c : 열 , 1번부터 시작
     * @param s : 좌표 추가 변수
     */

    public static void rotate(int r, int c, int s) {
        int leftX = c - s - 1;
        int leftY = r - s - 1;
        int rightX = c + s - 1;
        int rightY = r + s - 1;

        while (leftX < rightX && leftY < rightY) {

            int temp = map[leftY][leftX];

            for (int i = leftY + 1; i <= rightY; i++) {
                map[i - 1][leftX] = map[i][leftX];
            }
            for (int i = leftX + 1; i <= rightX; i++) {
                map[rightY][i - 1] = map[rightY][i];
            }
            for (int i = rightY - 1; i >= leftY; i--) {
                map[i + 1][rightX] = map[i][rightX];
            }
            for (int i = rightX - 1; i >= leftX + 1; i--) {
                map[leftY][i + 1] = map[leftY][i];
            }
            map[leftY][leftX + 1] = temp;
            leftX += 1;
            leftY += 1;
            rightX -= 1;
            rightY -= 1;
        }

    }

    public static int[][] cloneArray(int[][] map) {
        int[][] newArr = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            newArr[i] = map[i].clone();
        }
        return newArr;
    }

}
