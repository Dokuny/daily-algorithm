package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 23.07.19
 * 원래 소수를 Set에 넣어서 contains(N - 소수) 이런 식으로 계산했는데
 * 그럴 필요없이 그냥 어차피 두 수의 합이 N인 것을 찾는 거니까  N/2만큼 돌아보면 나온다.
 */

public class No_17103 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 에라토스테네스의 체
		boolean[] isPrime = new boolean[1000001];
		Arrays.fill(isPrime, true);

		isPrime[0] = false;
		isPrime[1] = false;


		for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
			if (isPrime[i]) {
				for (int j = i + i; j < isPrime.length; j += i) {
					isPrime[j] = false;
				}
			}
		}

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());

			// 어차피 두 수의 합을 구하는 것이기 때문에 n / 2 만큼만 돌면 됩니다.
			int size = n / 2;

			int cnt = 0;
			for (int j = 2; j <= size ; j++) {
				if(!isPrime[j] || !isPrime[n-j]) continue; // 두 수가 소수가 아니면 continue
				cnt++;
			}
			sb.append(cnt)
				.append("\n");

		}
		System.out.println(sb);

	}

}
