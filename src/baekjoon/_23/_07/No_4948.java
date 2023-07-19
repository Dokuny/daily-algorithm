package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 23.07.19
 */
public class No_4948 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean[] isPrime = new boolean[246913];
		int[] primeCnt = new int[246913];
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

		int cnt = 0;
		for (int i = 0; i < primeCnt.length ; i++) {
			if (isPrime[i]) {
				cnt++;
			}
			primeCnt[i] = cnt;
		}

		StringBuilder sb = new StringBuilder();
		while (true) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0) {
				break;
			}

			sb.append(primeCnt[2 * n] - primeCnt[n])
				.append("\n");

		}
		System.out.println(sb);

	}

}
