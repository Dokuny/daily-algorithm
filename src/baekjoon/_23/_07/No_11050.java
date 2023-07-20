package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 23.07.20 이항 계수 : 조합의 가짓수
 */
public class No_11050 {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// N! / (N-K)! K!
		int up = 1;
		for (int i = N; i > K; i--) {
			up *= i;
		}

		int down = 1;
		for (int i = 1; i <= N - K; i++) {
			down *= i;
		}

		System.out.println(up / down);
	}

}
