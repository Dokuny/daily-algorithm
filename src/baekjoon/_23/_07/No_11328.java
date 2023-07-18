package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 23.07.19
 */

public class No_11328 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String first = st.nextToken();
			String second = st.nextToken();

			int[] arr = new int[26];

			for (int j = 0; j < first.length(); j++) {
				arr[first.charAt(j) - 'a']++;
			}

			for (int j = 0; j < second.length(); j++) {
				arr[second.charAt(j) - 'a']--;
			}

			boolean isPossible = true;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] != 0) {
					isPossible = false;
					break;
				}
			}
			if (isPossible) {
				sb.append("Possible")
					.append("\n");
			} else {
				sb.append("Impossible")
					.append("\n");
			}
		}

		System.out.println(sb);
	}

}
