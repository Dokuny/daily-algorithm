import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {


	static int[] lps;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String word = br.readLine();
		String explorer = br.readLine();

		ArrayDeque<Character> stack = new ArrayDeque<>();
		ArrayDeque<Character> queue = new ArrayDeque<>();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < word.length(); i++) {
			stack.addLast(word.charAt(i));

			if (stack.size() >= explorer.length() && stack.peekLast()
				.equals(explorer.charAt(explorer.length() - 1))) {

				boolean isSame = true;

				for (int j = explorer.length() - 1; j >= 0; j--) {
					Character pop = stack.pollLast();

					if (pop.equals(explorer.charAt(j))) {
						queue.addLast(pop);
					} else {
						queue.addLast(pop);
						isSame = false;
						while (!queue.isEmpty()) {
							stack.addLast(queue.pollLast());
						}
						break;
					}
				}

				if (isSame) {
					queue.clear();
				}

			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pollFirst());
		}


		if (sb.length() == 0) {
			System.out.println("FRULA");
		} else {
			System.out.println(sb);
		}

		// ABBCC
	}

}

