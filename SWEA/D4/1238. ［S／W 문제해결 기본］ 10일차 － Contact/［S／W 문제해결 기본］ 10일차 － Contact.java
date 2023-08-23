import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

	static ArrayList<Node>[] adjList = new ArrayList[101];
	static boolean[] visited;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {

			st = new StringTokenizer(br.readLine());

			visited = new boolean[101];

			for (int i = 1; i <= 100; i++) {
				adjList[i] = new ArrayList<>();
			}

			int length = Integer.parseInt(st.nextToken()) / 2;
			int start = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < length; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				adjList[from].add(new Node(to, 0));
			}

			for (int i = 1; i <=100; i++) {
				adjList[i].sort(Comparator.comparingInt(c -> c.to));
			}

			Queue<Node> queue = new ArrayDeque<>();
			queue.add(new Node(start, 0));
			visited[start] = true;

			Node cur = null;
			int maxCnt = Integer.MIN_VALUE;
			int nodeNum = 0;
			while (!queue.isEmpty()) {
				cur = queue.poll();

				if (cur.cnt >= maxCnt) {
					if (cur.cnt == maxCnt) {
						nodeNum = Math.max(nodeNum, cur.to);
					} else {
						nodeNum = cur.to;
					}

					maxCnt = cur.cnt;
				}

				for (Node adj : adjList[cur.to]) {
					if (visited[adj.to]) {
						continue;
					}

					visited[adj.to] = true;
					queue.add(new Node(adj.to, cur.cnt + 1));
				}
			}

			sb.append("#").append(test_case).append(" ").append(nodeNum).append("\n");
		}
		System.out.println(sb);
	}

	static class Node {

		int to;
		int cnt;

		public Node(int to, int cnt) {
			this.to = to;
			this.cnt = cnt;
		}
	}

}