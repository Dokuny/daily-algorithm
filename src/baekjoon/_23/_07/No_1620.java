package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 23.07.18
 */

public class No_1620 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, String> set = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			set.put(String.valueOf(i), str);
			set.put(str, String.valueOf(i));
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			String str = br.readLine();

			sb.append(set.get(str))
				.append("\n");
		}

		System.out.println(sb);

	}

}
