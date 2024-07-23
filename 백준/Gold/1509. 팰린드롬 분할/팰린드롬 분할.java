import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int n = str.length();

        boolean[][] isPalindrome = new boolean[n][n];

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {

            int minCut = i + 1;

            for (int j = 0; j <= i; j++) {
                // 펠린드롬인지 확인
                // 기존 값에서 앞뒤가 같아야만 펠린드롬 요건 중 하나
                // 기존 값의 길이가 1이하이거나 펠린드롬이면 펠린드롬임
                if (str.charAt(i) == str.charAt(j) && (i - j <= 1 || isPalindrome[i - 1][j + 1])) {
                    isPalindrome[i][j] = true;

                    // 분할 계산 필요
                    minCut = (j == 0) ? 1 : Math.min(minCut, dp[j - 1] + 1);
                }
            }

            dp[i] = minCut;
        }

        System.out.println(dp[n - 1]);
    }

}
