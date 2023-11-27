import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 223 이 최대값
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(N, 0));

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			int sqrt = (int) Math.sqrt(cur.num);

			for (int i = sqrt; i >= 1; i--) {

				int pow = i * i;

				if (pow == cur.num) {
					System.out.println(cur.cnt + 1);
					return;
				}
				queue.add(new Node(cur.num - pow, cur.cnt + 1));
			}
		}
	}

	static class Node {
		int num;
		int cnt;

		public Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
}

