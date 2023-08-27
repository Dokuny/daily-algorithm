import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {


	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());

			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// 최소공배수 구하기
			int lcm = M * N / gcd(M, N);

			HashSet<Integer> set = new HashSet<>();

			int num = x;

			while (num <= lcm) {
				set.add(num);
				num += M;
			}

			num = y;
			int answer = -1;
			while (num <= lcm) {
				if (set.contains(num)) {
					answer = num;
					break;
				}
				num += N;
			}

			sb.append(answer).append("\n");
		}
		System.out.println(sb);

	}

	static int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		return gcd(b, a % b);
	}


}
