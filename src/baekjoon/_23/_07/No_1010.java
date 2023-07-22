package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 23.07.21
 */
public class No_1010 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			long up = 1;
			for (int j = M; j > N ; j--) {
				up *= j;
			}

			for (int j = M - N; j >= 1; j--) {
				up /= j;
			}

			sb.append(up)
				.append("\n");
		}

		// nCr
		// n! / (n-r)! r! = k


		System.out.println(sb);


	}

}
