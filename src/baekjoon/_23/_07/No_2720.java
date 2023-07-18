package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2720 {
	static int[] coins = {25, 10, 5, 1};

	// 그리디 알고리즘을 사용하면 풀 수 있는 문제
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int cur = Integer.parseInt(br.readLine());

			for (int j = 0; j < 4; j++) {
				sb.append(cur / coins[j])
					.append(" ");
				cur %= coins[j];
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
