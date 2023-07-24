package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 23.07.24
 */
public class No_18258 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Deque<Integer> deque = new ArrayDeque<>();

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			String operator = st.nextToken();

			switch (operator) {
				case "push":
					deque.addLast(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					if (deque.isEmpty()) {
						sb.append("-1").append("\n");
					} else {
						sb.append(deque.pollFirst()).append("\n");
					}
					break;
				case "size":
					sb.append(deque.size()).append("\n");
					break;
				case "empty":
					if (deque.isEmpty()) {
						sb.append("1").append("\n");
					} else {
						sb.append("0").append("\n");
					}
					break;
				case "front":
					if (deque.isEmpty()) {
						sb.append("-1").append("\n");
					} else {
						sb.append(deque.peekFirst()).append("\n");
					}
					break;
				case "back":
					if (deque.isEmpty()) {
						sb.append("-1").append("\n");
					} else {
						sb.append(deque.peekLast()).append("\n");
					}
					break;
			}
		}
		System.out.println(sb);
	}
}
