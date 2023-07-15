package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2501 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 최적화하려면, 10000까지 돌리지말고 K / 2 만큼 돌린 후,
		// 자기자신도 세야하니 K값에서 1빼준 후 K == 0 인지 확인, 아니라면 0 맞다면 자기자신 출력
		for (int i = 1; i <= 10000; i++) {
			if (N % i == 0) {
				K--;
			}
			if (K == 0) {
				System.out.println(i);
				return;
			}
		}

		if (K != 0) {
			System.out.println(0);
		}
	}

}
