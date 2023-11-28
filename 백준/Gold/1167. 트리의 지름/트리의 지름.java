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
	static long max;
	static int idx;

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
		max = Long.MIN_VALUE;
		idx = -1;

		dfs(1, 0);

		dfs(idx, 0);
		
		System.out.println(max);
	}

	static void dfs(int curNode, long value) {
		if (max < value) {
			max = value;
			idx = curNode;
		}

		visited[curNode] = true;

		for (Node adj : adjList[curNode]) {
			if(visited[adj.to]) continue;

			dfs(adj.to, value + adj.dist);
		}


		visited[curNode] = false;
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

