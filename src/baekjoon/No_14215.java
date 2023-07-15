package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_14215 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 가장 긴 변은 나머지 두 변의 합보다 작아야한다.
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int max = Math.max(a, Math.max(b, c));
		int sum = a + b + c - max;

		if (max >= sum) {
			// 가장 긴 변이 나머지 두 변의 합보다 크다면, 합-1 로 가장 긴 변을 변경
			System.out.println(sum + sum - 1);
		} else {
			System.out.println(a + b + c);
		}
	}

}
