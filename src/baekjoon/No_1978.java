package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1978 {

	// 에라토스테네스의 체 사용
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		boolean[] notPrime = new boolean[1001];
		notPrime[1] = true;

		for (int i = 2; i <= Math.sqrt(1000) ; i++) {
			if(notPrime[i]) continue;

			for (int j = i + i; j <= 1000 ; j += i) {
				notPrime[j] = true;
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());

			if (!notPrime[cur]) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

}
