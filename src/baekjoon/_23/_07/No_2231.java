package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2231 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		//  L = N의 자릿수
		//  K = 생성자
		//  F(L) = N = k1 + k2 + k3 ... + kL + K
		//  -> N - k1 - k2 - k3 .... = K
		//  k의 최대값은 9이므로 주어진 수 N에서 9*자릿수만큼 빼주면 생성자0의 최소 범위를 구할 수 있음
		//  K = N - 9 * N의 자릿수

		int answer = 0;
		for (int i = N - (9 * N); i < N; i++) {
			if(i < 0) continue; // 0보다 적은 생성자는 없음

			int n = i;
			int sum = n;

			while (n != 0) {
				sum += n % 10; // 각 자리 수 더하기
				n /= 10;
			}

			if (sum == N) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}

}
