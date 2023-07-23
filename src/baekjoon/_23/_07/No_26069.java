package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 23.07.23
 */
public class No_26069 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		HashSet<String> dancers = new HashSet<>();

		dancers.add("ChongChong");

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			String one = st.nextToken();
			String two = st.nextToken();

			if (dancers.contains(one) || dancers.contains(two)) {
				dancers.add(one);
				dancers.add(two);
			}
		}

		System.out.println(dancers.size());
	}

}
