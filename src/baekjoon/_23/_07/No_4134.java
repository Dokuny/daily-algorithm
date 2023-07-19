package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 23.07.19
 */
public class No_4134 {

	public static void main2(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long T = Long.parseLong(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			long n = Long.parseLong(br.readLine());

			if (n <= 1) {
				sb.append(2)
					.append("\n");
				continue;
			}

			for (long j = n; true; j++) {
				boolean isPrime = true;

				for (int k = 2; k <= Math.sqrt(j); k++) {
					if (j % k == 0) {
						isPrime = false;
						break;
					}
				}

				if (isPrime) {
					sb.append(j)
						.append("\n");
					break;
				}
			}
		}

		System.out.println(sb);
	}
}
