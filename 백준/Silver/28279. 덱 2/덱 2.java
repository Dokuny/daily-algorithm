import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;

		ArrayDeque<Integer> deque = new ArrayDeque<>();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			String input = br.readLine();

			if (input.length() > 1) {
				st = new StringTokenizer(input);

				int command = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());

				switch (command) {
					case 1:
						deque.addFirst(num);
						break;
					case 2:
						deque.addLast(num);
						break;
				}
			} else {
				int command = Integer.parseInt(input);
				switch (command) {
					case 3:
						if (deque.isEmpty()) {
							sb.append(-1);
						}else{
							sb.append(deque.pollFirst());
						}
						break;
					case 4:
						if (deque.isEmpty()) {
							sb.append(-1);
						}else{
							sb.append(deque.pollLast());
						}
						break;
					case 5:
						sb.append(deque.size());
						break;
					case 6:
						if (deque.isEmpty()) {
							sb.append("1");
						} else {
							sb.append("0");
						}
						break;
					case 7:
						if (deque.isEmpty()) {
							sb.append(-1);
						}else{
							sb.append(deque.peekFirst());
						}
						break;
					case 8:
						if (deque.isEmpty()) {
							sb.append(-1);
						}else{
							sb.append(deque.peekLast());
						}
						break;

				}
				sb.append("\n");
			}
		}

		System.out.println(sb);

	}

}
