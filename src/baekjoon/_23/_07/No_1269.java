package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


/**
 * 23.07.18
 */

public class No_1269 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		HashSet<Integer> set = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());

		int cnt = 0;

		for (int i = 0; i < B; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (set.contains(num)) {
				cnt++;
			}
		}

		System.out.println(set.size() - cnt + B - cnt);
	}

}
