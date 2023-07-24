package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 23.07.24
 */
public class No_4779 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input;

		while ((input = br.readLine()) != null) {
			int N = Integer.parseInt(input);

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < Math.pow(3, N); i++) {
				sb.append("-");
			}

			recur(sb, 0, sb.length() - 1);
			System.out.println(sb);
		}
	}

	public static void recur(StringBuilder sb, int left, int right) {
		if ((right - left + 1) < 3) {
			return;
		}

		int div = (right - left + 1) / 3;
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < div; i++) {
			temp.append(" ");
		}
		sb.replace(left + div, left + div * 2, temp.toString());
		recur(sb, left, left + div - 1);
		recur(sb, left + div * 2, right);


	}

}
