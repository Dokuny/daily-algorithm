import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        // 누적합 하다가 음수가 되는 순간 값을 0으로 초기화후 누적합 다시 시작

        int[] dp = new int[T+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int i = 1; i <= T; i++) {
            int num = Integer.parseInt(st.nextToken());
            max2 = Math.max(max2, num);
            int sum = dp[i - 1] + num;
            // 음수만 연달아 나오는 경우, 제대로 작동 x
            if (sum < 0) {
                dp[i] = 0;
                continue;
            } else {
                dp[i] = sum;
            }

            max = Math.max(max, dp[i]);
        }

        if (max == Integer.MIN_VALUE) {
            max = max2;
        }

        System.out.println(max);

    }

}
