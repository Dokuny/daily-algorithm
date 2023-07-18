package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int sum = 1;
		int start = 6;
		int cnt = 1;
		while (N > sum) {
			sum += start;
			start += 6;
			cnt++;
		}
		System.out.println(cnt);
	}

}
