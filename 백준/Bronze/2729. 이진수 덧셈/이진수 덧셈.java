import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder();

			st = new StringTokenizer(br.readLine());

			String first = st.nextToken();
			String second = st.nextToken();

			int firstIdx = first.length() - 1;
			int secondIdx = second.length() - 1;

			int remain = 0;

			while (firstIdx >= 0 && secondIdx >= 0) {
				int a = first.charAt(firstIdx--) - '0';
				int b = second.charAt(secondIdx--) - '0';

				int sum = a + b + remain;

				remain = sum / 2;
				sb.append(sum % 2);
			}

			while (firstIdx >= 0) {
				int a = first.charAt(firstIdx--) - '0';

				int sum = a + remain;
				remain = sum / 2;
				sb.append(sum % 2);
			}
			while (secondIdx >= 0) {
				int a = second.charAt(secondIdx--) - '0';

				int sum = a + remain;
				remain = sum / 2;
				sb.append(sum % 2);

			}
			if (remain > 0) {
				sb.append(remain);
			}

			sb.reverse();

			int idx = 0;
			for (int j = 0; j < sb.length(); j++) {
				if (sb.charAt(j) != '0') {
					answer.append(sb.substring(j)).append("\n");
					break;
				}
				if (j == sb.length() - 1) {
					answer.append(0).append("\n");
				}
			}
		}

		System.out.println(answer);
	}

}
