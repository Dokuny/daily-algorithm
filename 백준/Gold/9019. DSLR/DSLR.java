import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 이거 2번째 예제가 2
 */
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int test_case = 0; test_case < T; test_case++) {
			st = new StringTokenizer(br.readLine());

			int original = Integer.parseInt(st.nextToken());
			int converted = Integer.parseInt(st.nextToken());

			Queue<Num> queue = new ArrayDeque<>();
			queue.add(new Num("", original));

			boolean[] visited = new boolean[10000];
			visited[original] = true;

			while (!queue.isEmpty()) {
				Num cur = queue.poll();

				if (cur.num == converted) {
					sb.append(cur.command).append("\n");
					break;
				}

				int twice = twice(cur.num);
				if (!visited[twice]) {
					visited[twice] = true;
					queue.add(new Num(cur.command + "D", twice));
				}

				int minus = minus(cur.num);
				if (!visited[minus]) {
					visited[minus] = true;
					queue.add(new Num(cur.command + "S", minus));
				}

				int left = left(cur.num);
				if (!visited[left]) {
					visited[left] = true;
					queue.add(new Num(cur.command + "L", left));
				}

				int right = right(cur.num);
				if (!visited[right]) {
					visited[right] = true;
					queue.add(new Num(cur.command + "R", right));
				}

				if (converted == twice) {
					sb.append(cur.command + "D").append("\n");
					break;
				} else if (converted == minus) {
					sb.append(cur.command + "S").append("\n");
					break;
				} else if (converted == left) {
					sb.append(cur.command + "L").append("\n");
					break;
				} else if (converted == right) {
					sb.append(cur.command + "R").append("\n");
					break;
				}
			}
		}
		System.out.println(sb);

	}

	public static int twice(int number) {
		return number * 2 % 10000;
	}

	public static int minus(int number) {
		return (number + 9999) % 10000;
	}

	public static int left(int number) {
		char[] arr = String.valueOf(number).toCharArray();

		char[] ints = new char[4];
		Arrays.fill(ints, '0');
		System.arraycopy(arr, 0, ints, 4 - arr.length, arr.length);

		char temp = ints[0];
		for (int i = 1; i < ints.length; i++) {
			ints[i - 1] = ints[i];
		}
		ints[ints.length - 1] = temp;

		return Integer.parseInt(String.valueOf(ints));
	}

	public static int right(int number) {
		char[] arr = String.valueOf(number).toCharArray();

		char[] ints = new char[4];
		Arrays.fill(ints, '0');
		System.arraycopy(arr, 0, ints, 4 - arr.length, arr.length);

		char temp = ints[ints.length - 1];
		for (int i = ints.length - 2; i >= 0; i--) {
			ints[i + 1] = ints[i];
		}
		ints[0] = temp;

		return Integer.parseInt(String.valueOf(ints));
	}

	static class Num {

		String command;
		int num;

		public Num(String command, int num) {
			this.command = command;
			this.num = num;
		}
	}
}