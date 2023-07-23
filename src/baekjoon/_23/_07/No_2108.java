package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * 23.07.23
 */
public class No_2108 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		int[] arr = new int[T];

		int sum = 0;

		int num = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			sum += arr[i];

			if (map.get(arr[i]) > num) {
				num = map.get(arr[i]);
			}
		}

		ArrayList<Integer> list = new ArrayList<>(map.keySet());

		Arrays.sort(arr);
		Collections.sort(list);
		int cnt = 0;
		int ans = Integer.MAX_VALUE;
		for (Integer n : list) {
			if (map.get(n) == num) {
				cnt++;
				ans = n;
				if(cnt == 2) break;
			}
		}

		System.out.println(Math.round((double)sum / T));
		System.out.println(arr[arr.length / 2]);
		System.out.println(ans);
		System.out.println(arr[arr.length - 1] - arr[0]);



	}

}
