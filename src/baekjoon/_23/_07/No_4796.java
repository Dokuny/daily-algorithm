package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 23.07.19
 */
public class No_4796 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int idx = 1;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			long L = Long.parseLong(st.nextToken());
			long P = Long.parseLong(st.nextToken());
			long V = Long.parseLong(st.nextToken());

			if (L == 0 && P == 0 && V == 0) {
				break;
			}

			long answer = V / P * L + Math.min(V % P, L);

			sb.append("Case ")
				.append(idx++)
				.append(": ")
				.append(answer)
				.append("\n");
		}
		System.out.println(sb);
	}

}
