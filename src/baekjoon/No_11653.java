package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_11653 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		// 소수를 찾으려면 주어진 수의 제곱근만큼만 돌아보면 찾을 수 있음
		for (int i = 2; i <= Math.sqrt(N); i++) {
			// 소수로 나누어 진다면
			while (N % i == 0) {
				sb.append(i)
					.append("\n");
				N /= i;
			}
		}

		// N이 1이 아니면 자기 자신이 남았다는 소리
		if (N != 1) {
			sb.append(N);
		}

		System.out.println(sb);
	}
}
