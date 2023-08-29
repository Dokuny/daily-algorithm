import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {

	static int N;

	static boolean[][][] visited;

	static int[][] mutal = {{9, 3, 1}, {9, 1, 3}, {3, 1, 9}, {3, 9, 1}, {1, 3, 9}, {1, 9, 3}};

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = 0;
		int c = 0;

		if (N >= 2) {
			b = Integer.parseInt(st.nextToken());
		}
		if (N >= 3) {
			c = Integer.parseInt(st.nextToken());
		}

		visited = new boolean[a + 1][b + 1][c + 1];

		Queue<Node> queue = new ArrayDeque<>();

		queue.add(new Node(a, b, c, 0));

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			if (cur.a == 0 && cur.b == 0 && cur.c == 0) {
				System.out.println(cur.cnt);
				return;
			}

			for (int[] attack : mutal) {
				int nextA = Math.max(0, cur.a - attack[0]);
				int nextB = Math.max(0, cur.b - attack[1]);
				int nextC = Math.max(0, cur.c - attack[2]);

				if (visited[nextA][nextB][nextC]) {
					continue;
				}

				visited[nextA][nextB][nextC] = true;

				queue.add(
					new Node(nextA, nextB, nextC, cur.cnt + 1));
			}
		}
	}


	static class Node {

		int a;
		int b;
		int c;

		int cnt;

		public Node(int a, int b, int c, int cnt) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.cnt = cnt;
		}
	}


}