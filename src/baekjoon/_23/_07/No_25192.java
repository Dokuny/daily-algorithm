package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 *
 * 23.07.23
 */
public class No_25192 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		HashSet<String> set = null;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String cur = br.readLine();
			if (cur.equals("ENTER")) {
				set = new HashSet<>();
				continue;
			}

			if (!set.contains(cur)) {
				cnt++;
				set.add(cur);
			}
		}

		System.out.println(cnt);

	}

}
