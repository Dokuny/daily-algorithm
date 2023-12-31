package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 23.07.24
 */
public class No_10828 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;

		Stack<Integer> stack = new Stack<>();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			String operator = st.nextToken();

			switch (operator) {
				case "push":
					stack.push(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					if(stack.isEmpty()) sb.append(-1).append("\n");
					else sb.append(stack.pop()).append("\n");
					break;
				case "size":
					sb.append(stack.size()).append("\n");
					break;
				case "empty":
					if(stack.isEmpty()) sb.append(1).append("\n");
					else sb.append(0).append("\n");
					break;
				case "top":
					if(stack.isEmpty()) sb.append(-1).append("\n");
					else sb.append(stack.peek()).append("\n");
					break;
			}
		}
		System.out.println(sb);
	}
}
