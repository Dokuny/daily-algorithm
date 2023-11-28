import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visited;
	static ArrayList<Node>[] adjList;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int V = Integer.parseInt(br.readLine());

		adjList = new ArrayList[V + 1];

		for (int i = 0; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}

		StringTokenizer st;
		for (int i = 1; i <= V; i++) {
			st = new StringTokenizer(br.readLine());

			int baseNode = Integer.parseInt(st.nextToken());

			while (true) {
				int adjNode = Integer.parseInt(st.nextToken());

				if (adjNode == -1) {
					break;
				}

				long dist = Long.parseLong(st.nextToken());

				adjList[baseNode].add(new Node(adjNode, dist));
			}
		}

		visited = new boolean[V + 1];

		Queue<Node> queue = new ArrayDeque<>();
		visited[1] = true;
		queue.add(new Node(1, 0));

		long max = Long.MIN_VALUE;
		int idx = -1;

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			if (cur.dist > max) {
				max = cur.dist;
				idx = cur.to;
			}

			ArrayList<Node> nodes = adjList[cur.to];

			for (Node node : nodes) {
				if (visited[node.to]) {
					continue;
				}
				long newDist = node.dist + cur.dist;

				queue.add(new Node(node.to, newDist));
				visited[node.to] = true;
			}
		}

		queue = new ArrayDeque<>();
		visited = new boolean[V + 1];
		visited[idx] = true;
		queue.add(new Node(idx, 0));

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			if (cur.dist > max) {
				max = cur.dist;
			}

			for (Node node : adjList[cur.to]) {
				if (visited[node.to]) {
					continue;
				}
				long newDist = node.dist + cur.dist;

				queue.add(new Node(node.to, newDist));
				visited[node.to] = true;
			}
		}
		System.out.println(max);
	}

	static class Node  {

		int to;
		long dist;

		public Node(int to, long dist) {
			this.to = to;
			this.dist = dist;
		}
	}

}

