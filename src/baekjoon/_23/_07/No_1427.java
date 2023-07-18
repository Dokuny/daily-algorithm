package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1427 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		int[] arr = new int[10];

		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - '0']++;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < arr[i]; j++) {
				sb.append(i);
			}
		}
		System.out.println(sb);
	}

}
