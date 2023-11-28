import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int V = Integer.parseInt(br.readLine());

		ArrayList<Node>[] adjList = new ArrayList[V + 1];

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
		long max = 0;
		int idx = -1;

		long[] dist = new long[V + 1];
		Arrays.fill(dist, Long.MAX_VALUE);

		dist[1] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (dist[cur.to] < cur.dist) {
				continue;
			}

			for (Node adj : adjList[cur.to]) {
				long newDist = adj.dist + dist[cur.to];

				if (newDist < dist[adj.to]) {
					dist[adj.to] = newDist;
					pq.add(new Node(adj.to, newDist));
				}
			}
		}

		for (int j = 1; j <= V; j++) {
			if (dist[j] != Long.MAX_VALUE) {

				if (max < dist[j]) {
					max = dist[j];
					idx = j;
				}
			}
		}

		dist = new long[V + 1];
		Arrays.fill(dist, Long.MAX_VALUE);

		dist[idx] = 0;

		pq = new PriorityQueue<>();
		pq.add(new Node(idx, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (dist[cur.to] < cur.dist) {
				continue;
			}

			for (Node adj : adjList[cur.to]) {
				long newDist = adj.dist + dist[cur.to];

				if (newDist < dist[adj.to]) {
					dist[adj.to] = newDist;
					pq.add(new Node(adj.to, newDist));
				}
			}
		}

		for (int j = 1; j <= V; j++) {
			if (dist[j] != Long.MAX_VALUE) {

				if (max < dist[j]) {
					max = dist[j];
				}
			}
		}
		System.out.println(max);
	}

	static class Node implements Comparable<Node> {

		int to;
		long dist;

		public Node(int to, long dist) {
			this.to = to;
			this.dist = dist;
		}


		@Override
		public int compareTo(Node o) {
			return Long.compare(dist, o.dist);
		}
	}

}

