package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class No_10101 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		HashSet<Integer> set = new HashSet<>();
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			int n = Integer.parseInt(br.readLine());

			set.add(n);
			sum += n;
		}

		if (sum == 180) {
			if (set.size() == 1) {
				System.out.println("Equilateral");
			} else if (set.size() == 2) {
				System.out.println("Isosceles");
			} else {
				System.out.println("Scalene");
			}
		} else {
			System.out.println("Error");
		}
	}

}
