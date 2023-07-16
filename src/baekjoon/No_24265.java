package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_24265 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Long n = Long.parseLong(br.readLine());

		// 상단 반복문은 n-1번
		// 하단 반복문은 상단 반복문 반복 회차마다 다음과 같은 실행 횟수를 가짐
		// n-1, n-2, n-3 ... 1
		// 즉, 1 ~ n-1까지의 합이 정답
		System.out.println((n - 1) * n / 2);
		System.out.println(2);

	}

}
