package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 23.07.19
 */
public class No_1874 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		int idx = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int outNum = Integer.parseInt(br.readLine());

			// 추가해야하면 일단 추가
			while (idx <= outNum) {
				stack.push(idx++);
				sb.append("+")
					.append("\n");
			}

			int cur;

			do {
				// 빼야할게 있는데 스택에 들어있는게 없다면 불가능함
				if (stack.isEmpty()) {
					System.out.println("NO");
					return;
				}
				cur = stack.pop();
				sb.append("-")
					.append("\n");
			} while (cur != outNum);
		}
		System.out.println(sb);
	}
}
