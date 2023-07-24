package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 23.07.24
 */
public class No_9012 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			String input = br.readLine();

			int cnt = 0;

			for (int j = 0; j < input.length(); j++) {
				char cur = input.charAt(j);

				if (cur == '(') cnt++;
				else if (cur == ')') {
					cnt--;
					if (cnt < 0) {
						break;
					}
				}
			}
			if (cnt != 0) {
				sb.append("NO")
					.append("\n");
			} else {
				sb.append("YES")
					.append("\n");
			}
		}

		System.out.println(sb);

	}
}
