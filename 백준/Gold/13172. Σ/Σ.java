import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1000000007;


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());

		long sum = 0;
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());

			// S / N
			long inverse = inverse(N, MOD - 2);
			sum += S * inverse % MOD;
			sum %= MOD;
		}

		System.out.println(sum);

	}

	static long inverse(long a, int p) {
		long base = 1;

		while (p > 0) {
			if (p % 2 == 1) {
				base *= a;
				base %= MOD;
			}

			p /= 2;
			a *= a;
			a %= MOD;
		}

		return base;
	}

}