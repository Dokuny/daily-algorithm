package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 23.07.24
 */
public class No_11866 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		int cnt = 0;
		int idx = 0;
		int[] arr = new int[N];

		while (!queue.isEmpty()) {
			Integer poll = queue.poll();
			cnt++;

			if (cnt == K) {
				cnt = 0;
				arr[idx++] = poll;
				continue;
			}

			queue.add(poll);

		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");

		for (int i = 0; i < N - 1; i++) {
			sb.append(arr[i] + ", ");
		}
		sb.append(arr[arr.length - 1] + ">");
		System.out.println(sb);
	}
}
