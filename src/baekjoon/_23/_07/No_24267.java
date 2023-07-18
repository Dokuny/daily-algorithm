package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_24267 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());
		// 기존 풀이
//		long sum = 0;
//
//		for (long i = n - 2; i >= 1; i--) {
//			sum += i * (i + 1) / 2;
//		}
//		System.out.println(sum);
//		System.out.println(3);

		// 새로운 풀이
		System.out.println(n * (n - 1) * (n - 2) / 6);
		System.out.println(3);
	}

}
