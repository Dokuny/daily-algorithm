package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2903 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int start = 2;

		for (int i = 1; i <= N; i++) {
			start = start * 2 - 1;
		}

		System.out.println(start * start);
	}
}
