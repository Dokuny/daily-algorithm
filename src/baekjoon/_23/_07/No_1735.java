package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 23.07.19
 */
public class No_1735 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

		st = new StringTokenizer(br.readLine());
		int[] b = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

		// 최소 공배수 구하기
		int denom = lcm(a[1], b[1]);

		int numer = denom / a[1] * a[0] + denom / b[1] * b[0];

		int gcd = gcd(numer, denom);

		System.out.println(numer / gcd + " " + denom / gcd);

	}

	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	private static int gcd(int a, int b) {
		while (a % b != 0) {
			int temp = a;
			a = b;
			b = temp % b;
		}
		return b;
	}

}
