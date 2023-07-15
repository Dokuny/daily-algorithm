package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class No_3009 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		HashSet<Integer> xSet = new HashSet<>();
		HashSet<Integer> ySet = new HashSet<>();
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (xSet.contains(x)) {
				xSet.remove(x);
			}else{
				xSet.add(x);
			}

			if (ySet.contains(y)) {
				ySet.remove(y);
			} else {
				ySet.add(y);
			}
		}

		StringBuilder sb = new StringBuilder();

		for (Integer i : xSet) {
			sb.append(i).append(" ");
		}

		for (Integer i : ySet) {
			sb.append(i);
		}

		System.out.println(sb);
	}

}
