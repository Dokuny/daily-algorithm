package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 23.07.20 이항 계수 : 조합의 가짓수
 */
public class No_11050 {


	// DP 이용
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int result = bottomUp(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		System.out.println(result);

	}

	public static int bottomUp(int n, int k) {
		// 계산한 값을 저장한 배열 선언
		int[][] dp = new int[n + 1][k + 1]; // 0번 값도 필요하니 +1 만큼 크기로 선언

		for (int i = 0; i <= n; i++) { // n이 0일 때부터 하나씩 구해가기
			for (int j = 0; j <= Math.min(i, k); j++) { // k <= n이여야 하므로
				if (j == 0 || j == i) { // k = 0 이거나 k = n 이라면 1
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]; // 저장 배열에서 가져와서 저장
				}
			}
		}

		return dp[n][k];
	}
	public static void main1(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] factorial = new int[10];
		factorial[0] = factorial[1] = 1;

		for (int i = 2; i < 10; i++) {
			factorial[i] = factorial[i - 1] * i;
		}

		String N = Integer.toString(Integer.parseInt(st.nextToken()), 7);
		String K = Integer.toString(Integer.parseInt(st.nextToken()), 7);

		for (int i = K.length(); i <= N.length(); i++) {
			K = "0" + K;
		}

		for (int i = 0; i < N.length(); i++) {
			char n_i = N.charAt(i);
			char k_i = K.charAt(i);

			if (n_i < k_i) {
				System.out.println(0);
			}
		}

	}


//	public static void main(String[] args) throws IOException {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		int N = Integer.parseInt(st.nextToken());
//		int K = Integer.parseInt(st.nextToken());
//
//		// N! / (N-K)! K!
//		int up = 1;
//		for (int i = N; i > K; i--) {
//			up *= i;
//		}
//
//		int down = 1;
//		for (int i = 1; i <= N - K; i++) {
//			down *= i;
//		}
//
//		System.out.println(up / down);
//	}

}
