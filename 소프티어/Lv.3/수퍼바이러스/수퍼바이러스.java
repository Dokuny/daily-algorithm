import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 시간
		long K = Long.parseLong(st.nextToken());

		// 초당 증가율
		long P = Long.parseLong(st.nextToken());

		// 처음 바이러스 수
		long N = Long.parseLong(st.nextToken())  * 10;

		int mod = 1000000007;

		// 제곱 -> K * P^N
		// 분할정복

		long a = 1;
		while (N != 0) {
			if (N % 2 == 1) {
				a *= P;
				a %= mod;
			}

			N /= 2;
			P = (P * P) % mod;
		}

		System.out.println(((a % mod) * (K % mod)% mod));

	}

}
