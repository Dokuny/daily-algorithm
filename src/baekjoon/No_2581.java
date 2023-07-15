
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2581 {

	// 에라토스테네스의 체 사용
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());


		boolean[] notPrime = new boolean[N+1];
		notPrime[1] = true;

		for (int i = 2; i <= Math.sqrt(N) ; i++) {
			if(notPrime[i]) continue;

			for (int j = i + i; j <= N ; j += i) {
				notPrime[j] = true;
			}
		}

		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = M; i <= N; i++) {

			if (!notPrime[i]) {
				min = min > i ? i : min;
				sum += i;
			}
		}

		if (sum == 0) {
			System.out.println(-1);
			return;
		}

		System.out.println(sum);
		System.out.println(min);
	}
}
