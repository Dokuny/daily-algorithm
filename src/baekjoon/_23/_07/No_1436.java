package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No_1436 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer> list = new ArrayList<>();

		list.add(666);

		for (int i = 1666; list.size() != N; i++) {
			if (String.valueOf(i).contains("666")) {
				list.add(i);
			}
		}

		System.out.println(list.get(N-1));
	}

}
