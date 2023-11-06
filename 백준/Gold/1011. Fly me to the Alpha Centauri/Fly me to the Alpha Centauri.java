import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int test_case = 0; test_case < T; test_case++) {
			st = new StringTokenizer(br.readLine());
			long x = Integer.parseInt(st.nextToken());
			long y = Integer.parseInt(st.nextToken());

			long left = (long) (Math.sqrt(y - x));
			long right = left + 1;

			// n(n+1) -
			if ((left * left + right * right) / 2 >= y - x) {
				if (left * left == y - x) {
					sb.append(left * 2 - 1);
				} else {
					sb.append(left * 2);
				}
			} else {
				sb.append(right * 2 - 1);
			}
			sb.append("\n");

		}

		System.out.println(sb);
	}

}