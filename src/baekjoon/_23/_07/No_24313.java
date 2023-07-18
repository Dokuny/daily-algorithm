package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_24313 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int a1 = Integer.parseInt(st.nextToken());
		int a0 = Integer.parseInt(st.nextToken());

		int c = Integer.parseInt(br.readLine());
		int n0= Integer.parseInt(br.readLine());

		boolean isPossible = true;
		for (int i = n0; i <=100 ; i++) {
			if (a1 * i + a0 > c * i) {
				isPossible = false;
				break;
			}
		}

		if (isPossible) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

}
