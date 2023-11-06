import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		long[][] base = new long[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				base[i][j] = Long.parseLong(st.nextToken());
			}
		}

		long[][] pow = pow(base, B);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(pow[i][j] % 1000).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	public static long[][] pow(long[][] base, long p) {
		if (p == 1) {
			return base;
		}

		p = p-1;

		long[][] answer = base;

		while (p > 0) {
			if (p % 2 == 1) {
				answer = multiple(answer, base);
			}
			base = multiple(base, base);
			p /= 2;
		}

		return answer;
	}

	public static long[][] multiple(long[][] a, long[][] b) {

		long[][] result = new long[N][N];

		for (int i = 0; i < N; i++) { // 왼쪽 행렬
			for (int j = 0; j < N; j++) { // 오른쪽 행렬
				long sum = 0;
				for (int k = 0; k < N; k++) {
					sum += (a[i][k] * b[k][j]) % 1000;
				}
				result[i][j] = sum % 1000;
			}
		}

		return result;
	}

}