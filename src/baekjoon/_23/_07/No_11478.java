package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * 23.07.19
 * 더 좋은 풀이를 찾아볼 것
 */

public class No_11478 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		HashSet<String> set = new HashSet<>();

		for (int i = 1; i <= str.length(); i++) {
			for (int j = 0; j <= str.length() - i; j++) {
				set.add(str.substring(j, j + i));
			}
		}

		System.out.println(set.size());
	}
}
