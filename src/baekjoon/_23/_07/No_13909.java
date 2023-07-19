package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 23.07.19
 */
public class No_13909 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 24의 경우, 열 닫 열 닫 열 닫 열 닫
		// 11의 경우, 열 닫
		// 12의 경우, 열 닫 열 닫 열 닫
		// 16의 경우, 열 닫 열 닫 열
		// 4의 경우, 열 닫 열
		// 즉 제곱인 수만 열려있음
		int cnt = 0;
		for (long i = 1; i <= N; i++) {
			if(i * i > N) break;
			cnt++;
		}
		System.out.println(cnt);
	}

}
