import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final long MOD = 1000000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N < 10) {
            System.out.println(0);
            return;
        }

        // [len][digit][bitmask]
        long[][][] dp = new long[N + 1][10][1024];

        // 자리 수별 계단 수 체크해나가면 된다.
        // 1자리수 계단 수는 본인 자체
        for (int i = 1; i <= 9; i++) {
            dp[1][i][1 << i] = 1; // 자기 자신의 수로 채웠을 때 계단 수는 1개
        }

        // 전체 계단수를 다구하고 bitmask(모든 수)가

        // 1자리 수부터 N자리 수까지 계단 수를 채워나가기
        for (int len = 2; len <= N; len++) {
            // 계단 마지막에 숫자하나를 붙인다는 개념으로
            for (int digit = 0; digit <= 9; digit++) {
                // bitmask는 해당 자리수가 선택되었는지
                for (int bitmask = 0; bitmask < 1024; bitmask++) {
                    // 0이 아니면 자기보다 작은 수를 선택할 수 있음
                    // 선택된 숫자의 경우(bitmask)에 선택한 숫자(digit)를 추가한 경우(mask)
                    int mask = bitmask | (1 << digit);

                    if (digit > 0) {
                        // 이전 자리 수, 이전 숫자, 이전 경우의 계단 수를 더해주기
                        dp[len][digit][mask] += dp[len - 1][digit - 1][bitmask];
                        dp[len][digit][mask] %= MOD;
                    }

                    if (digit < 9) {
                        // 위와 반대로
                        dp[len][digit][mask] += dp[len - 1][digit + 1][bitmask];
                        dp[len][digit][mask] %= MOD;
                    }
                }
            }
        }

        // 숫자가 모두 사용된 계단 수 가져오기
        long result = 0;

        for (int i = 0; i < 10; i++) {
            result += dp[N][i][1023];
            result %= MOD;
        }

        System.out.println(result);
    }

}
