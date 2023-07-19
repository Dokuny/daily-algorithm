package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 23.07.19
 * 에라토스테네스의 체 이용
 */
public class No_1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		boolean[] primes = new boolean[N + 1];
		Arrays.fill(primes, true);

		primes[0] = false;
		primes[1] = false;

		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (primes[i]) {
				for (int j = i + i; j <= N; j += i) {
					primes[j] = false;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = M; i <= N; i++) {
			if (primes[i]) {
				sb.append(i)
					.append("\n");
			}
		}
		System.out.println(sb);
	}
}
