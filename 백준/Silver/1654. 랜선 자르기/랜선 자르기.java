import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int K;
    static int N;

    static int[] wires;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        wires = new int[K];

        // 최대값 구하기
        long right = Integer.MIN_VALUE;
        for (int i = 0; i < K; i++) {
            wires[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, wires[i]);
        }

        right++;

        long left = 0;

        while (left < right) {

            long mid = (right + left) / 2;

            long cnt = 0;

            for (int wire : wires) {
                cnt += wire / mid;
            }

            if (cnt < N) {
                right = mid;
            } else {
                left = mid + 1;

            }
        }

        System.out.println(right - 1);

    }

}

