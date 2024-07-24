import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        switch (N) {
            case 1:
                System.out.println(0);
                return;
            case 2:
                System.out.println(1);
                return;
            case 3:
                System.out.println(1);
                return;
        }

        // 1.소수 판별 로직 (에라토스테네스의 체)
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        int primeCnt = N - 1;
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    if (!isPrime[j]) continue;
                    isPrime[j] = false;
                    primeCnt--;
                }
            }
        }

        // 2. 소수의 누적합 계산하기
        long[] accumulateSum = new long[primeCnt + 1];

        int idx = 2;
        accumulateSum[0] = 0;
        accumulateSum[1] = 2;


        for (int i = 3; i <= N; i++) {
            if (isPrime[i]) {
                accumulateSum[idx] = accumulateSum[idx - 1] + i;
                idx++;
            }
        }

        int left = 0;
        int right = 0;
        int cnt = 0;

        while (right < accumulateSum.length) {
            long diff = accumulateSum[right] - accumulateSum[left];
            if (diff == N) {
                cnt++;
                left++;
                right++;
            } else if (diff < N) {
                right++;
            } else {
                left++;
            }
        }

        System.out.println(cnt);
    }

}
