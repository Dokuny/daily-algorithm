import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {

	static final int P = 1234567891;

	static long[] fact;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		// 팩토리얼 값 저장
		fact = new long[1000001];
		fact[0] = 1;

		// 팩토리얼 계산을 모듈러 연산으로 수행
		for (int i = 1; i <= 1000000; i++) {
			fact[i] = (fact[i - 1] * i) % P;
		}

		for (int test_case = 1; test_case <= T; test_case++) {

			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			sb.append("#").append(test_case).append(" ").append(binomialCoefficient(a, b))
				.append("\n");
		}
		System.out.println(sb);
	}

	public static long binomialCoefficient(int n, int k) {
		// nC0 = 1이므로
		if (k == 0) {
			return 1;
		}

		// 분모의 팩토리얼 계산
		long denominator = (fact[k] * fact[n - k]) % P;

		// 분자와 분모의 역원을 계산하여 이항계수 구하기
		return (fact[n] * modInverse(denominator, P - 2)) % P;
	}

	// 모듈러 연산의 역원을 구하는 함수 (분할정복 이용)
	// k < p일 때만 가능
	private static long modInverse(long a, int p) {
		long result = 1;

		while (p > 0) {
			// 지수가 홀 수면 하나가 남는 것이므로 결과 값에 한번 곱해주고 나눠준다.
			if (p % 2 == 1) {
				result *= a;
				result %= P;
			}
			a = (a * a) % P;
			p /= 2;  // 지수를 절반으로 나누기
		}

		return result;
	}


}