package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No_18870 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] sorted = arr.clone();

		Arrays.sort(sorted);

		HashMap<Integer, Integer> map = new HashMap<>();

		int sum = 1;
		map.put(sorted[0], 0);

		for (int i = 1; i < sorted.length; i++) {
			if (sorted[i] == sorted[i - 1]) continue;
			map.put(sorted[i], sum);
			sum++;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {
			sb.append(map.get(arr[i]))
				.append(" ");
		}
		System.out.println(sb);

	}

}
