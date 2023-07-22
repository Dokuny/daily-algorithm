package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 23.07.22
 */
public class No_2960 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 소수인지 체크하는 배열
		boolean[] isPrime = new boolean[N + 1];

		// 일단은 모두 true로 하여 소수라고 가정
		Arrays.fill(isPrime, true);

		// 0과 1은 소수가 아니므로 false
		isPrime[0] = false;
		isPrime[1] = false;

		// 지워진 수를 체크할 카운트 변수
		int cnt = 0;

		// 2부터 N까지 반복
		for (int i = 2; i <= N; i++) {
			// 소수라면
			if (isPrime[i]) {
				// 소수의 배수들을 삭제
				for (int j = i; j <= N; j += i) {
					// 이미 삭제된 애들은 다시 삭제하면 안되므로 조건 설정
					if (isPrime[j]) {
						cnt++;
						isPrime[j] = false;
						if (cnt == K) {
							System.out.println(j);
							return;
						}
					}
				}
			}
		}
	}


}
