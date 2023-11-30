import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

	static String input;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		input = br.readLine();

		System.out.println(dfs(0).word);

	}

	static Node dfs(int idx) {

		ArrayDeque<String> word = new ArrayDeque<>();
		ArrayDeque<String> oper = new ArrayDeque<>();


		while (idx < input.length()) {
			char c = input.charAt(idx);

			if (c == '(') {
				Node complete = dfs(idx + 1);

				word.add(complete.word);
				idx = complete.idx;
			} else if (c == ')') {
				// 정리하기
				while (!oper.isEmpty()) {
					word.addFirst(word.pollFirst() + word.pollFirst() + oper.pollFirst());
				}
				return new Node(word.pollFirst(), idx);
			} else if (c >= 'A' && c <= 'Z') {
				// word에 넣기
				word.add(String.valueOf(c));
			} else {
				oper.add(String.valueOf(c));
			}
			idx++;

			if (!oper.isEmpty() && (oper.peekLast().equals("*") || oper.peekLast().equals("/")) && !oper.peekLast().equals(String.valueOf(c))) {
					String after = word.pollLast();
					String before = word.pollLast();

					word.add(before + after + oper.pollLast());
			}
		}



		while (!oper.isEmpty()) {
			word.addFirst(word.pollFirst()  + word.pollFirst() + oper.pollFirst());
		}

		return new Node(word.pollFirst(), idx);
	}

	static class Node {

		String word;
		int idx;

		public Node(String word, int idx) {
			this.word = word;
			this.idx = idx;
		}
	}

}

