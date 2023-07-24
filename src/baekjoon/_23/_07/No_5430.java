package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 23.07.24
 */
public class No_5430 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < T; i++) {

			String operator = br.readLine();

			int n = Integer.parseInt(br.readLine());

			int[] arr = new int[n];

			String input = br.readLine();

			StringTokenizer st = new StringTokenizer(input.substring(1, input.length() - 1), ",");

			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			int left = 0;
			int right = arr.length - 1;
			boolean isReverse = false;
			boolean isSuccess = true;
			for (int j = 0; j < operator.length(); j++) {
				if (operator.charAt(j) == 'R') {
					isReverse = !isReverse;
				} else {
					if (!isReverse) {
						if (left >= arr.length || arr[left] == 0) {
							isSuccess = false;
							break;
						}
						arr[left++] = 0;
					} else {
						if (right < 0 || arr[right] == 0) {
							isSuccess = false;
							break;
						}
						arr[right--] = 0;
					}
				}
			}

			StringBuilder sb = new StringBuilder();
			if (isSuccess) {
				sb.append("[");

				if (isReverse) {
					for (int j = arr.length-1; j >= 0; j--) {
						if (arr[j] != 0) {
							sb.append(arr[j]).append(",");
						}

						if (j == 0) {
							int idx = sb.lastIndexOf(",");
							if (idx != -1 && idx == sb.length() - 1) {
								sb.deleteCharAt(idx);
							}
						}
					}
				} else {
					for (int j = 0; j < arr.length; j++) {
						if (arr[j] != 0) {
							sb.append(arr[j]).append(",");
						}

						if (j == arr.length - 1) {
							int idx = sb.lastIndexOf(",");
							if (idx != -1 && idx == sb.length() - 1) {
								sb.deleteCharAt(idx);
							}
						}
					}
				}
				sb.append("]");

			} else {
				sb.append("error");
			}

			answer.append(sb)
				.append("\n");
		}
		System.out.println(answer);

	}
}
