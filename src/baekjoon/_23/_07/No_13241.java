package baekjoon._23._07;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 23.07.19
 */
public class No_13241 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		System.out.println(lcm(A,B));
	}

	private static long lcm(long a, long b) {
		long multiple = a * b;

		while (a % b != 0) {
			long temp = a;
			a = b;
			b = temp % b;
		}

		return multiple / b;
	}

}
