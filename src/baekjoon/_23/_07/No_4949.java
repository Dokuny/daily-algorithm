package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_4949 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str;
		Stack<Character> stack;
		StringBuilder sb = new StringBuilder();
		while (!(str = br.readLine()).equals(".")) {

			stack = new Stack<>();
			boolean isYes = true;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(' || str.charAt(i) == '[') {
					stack.add(str.charAt(i));
				} else if (str.charAt(i) == ')' || str.charAt(i) == ']') {
					if (stack.isEmpty()) {
						isYes = false;
						break;
					}

					Character pop = stack.pop();

					if (str.charAt(i) == ')') {
						if (pop != '(') {
							isYes = false;
							break;
						}
					} else {
						if (pop != '[') {
							isYes = false;
							break;
						}
					}
				}
			}

			if (!stack.isEmpty()) {
				isYes = false;
			}

			if (isYes) {
				sb.append("yes").append("\n");
			} else {
				sb.append("no").append("\n");
			}
		}
		System.out.println(sb);

	}
}
