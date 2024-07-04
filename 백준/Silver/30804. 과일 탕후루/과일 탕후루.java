import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int[] fruits;
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1~9까지 과일의 부분집합으로 생각하자.
        // 9C2 = 9! / (2! * 7!) = 36

        // 과일 개수 * 과일종류 부분집합 개수 = 200000 * 36 = 720만

        int N = Integer.parseInt(br.readLine());
        visited = new boolean[10];

        fruits = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        recur(0, 1);

        System.out.println(max);

    }

    public static void recur(int N, int idx) {
        if (N == 2) {
            // 과일 배열 순회
            int maxCnt = 0;
            for (int i = 0; i < fruits.length; i++) {
                if (visited[fruits[i]]) {
                    maxCnt++;
                    continue;
                }
                max = Math.max(max, maxCnt);
                maxCnt = 0;
            }

            max = Math.max(max, maxCnt);
            return;
        }

        for (int i = idx; i <= 9; i++) {
            visited[i] = true;

            recur(N + 1, idx + 1);

            visited[i] = false;
        }
    }

}
