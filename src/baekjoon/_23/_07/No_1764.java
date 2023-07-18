package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 23.07.18
 */

public class No_1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashSet<String> set = new HashSet<>();



		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		StringBuilder sb = new StringBuilder();

		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String str = br.readLine();

			if (set.contains(str)) {
				list.add(str);
			}
		}

		Collections.sort(list);

		sb.append(list.size())
			.append("\n");

		for (String s : list) {
			sb.append(s)
				.append("\n");
		}

		System.out.println(sb);
	}

}
