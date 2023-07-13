package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2588 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A = Integer.parseInt(br.readLine());
		String B = br.readLine();

		int sum = 0; // 합
		int digit = 1; // 자리수
		for (int i = B.length()-1; i >= 0; i--) {
			System.out.println(A * (B.charAt(i) - '0'));
			sum += A * (B.charAt(i) - '0') * digit;
			digit *= 10;
		}
		System.out.println(sum);
	}

}
