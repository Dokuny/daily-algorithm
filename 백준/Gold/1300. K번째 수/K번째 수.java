import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long K = Long.parseLong(br.readLine());

        // 이분 탐색
        // 1 ~ N*N까지
        long left = 1L;
        long right = N * N;

        while (left < right) {
            long mid = (left + right) / 2;

            long cnt = 0;
            // 1부터 N까지 Mid에 몇개가 포함되는지 확인.
            for (long i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }
            if (cnt < K) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left);

    }
}
