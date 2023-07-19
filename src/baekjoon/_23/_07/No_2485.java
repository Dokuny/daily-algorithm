package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 23.07.19
 */
public class No_2485 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int[] diffs = new int[n - 1];

		for (int i = 1; i < n; i++) {
			diffs[i - 1] = arr[i] - arr[i - 1];
		}

		int answer = diffs[0];
		for (int i = 1; i < diffs.length; i++) {
			answer = gcd(answer, diffs[i]);
		}

		System.out.println((arr[arr.length - 1] - arr[0]) / answer - arr.length + 1);
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
