package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 23.07.24
 */
public class No_27433 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		System.out.println(factorial(N));

	}

	public static long factorial(long n) {
		if(n <= 1) return 1;
		return n * factorial(n - 1);
	}

}
