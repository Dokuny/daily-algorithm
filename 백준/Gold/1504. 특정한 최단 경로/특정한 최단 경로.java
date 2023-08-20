import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static ArrayList<Node>[] adjList;
	static int V;
	static int E;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());

			adjList[a].add(new Node(b, w));
			adjList[b].add(new Node(a, w));
		}

		st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken()) - 1;
		int b = Integer.parseInt(st.nextToken()) - 1;

		long ab = dijkstra(a, b);

		long first = dijkstra(0, a) + ab + dijkstra(b, V - 1);
		if(first <= 0) first = Long.MAX_VALUE;

		long second = dijkstra(0, b) + ab + dijkstra(a, V - 1);
		if(second <= 0) second = Long.MAX_VALUE;

		long result = Math.min(first, second);

		if (result == Long.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}

	}

	static long dijkstra(int start, int end) {

		long[] dist = new long[V];
		Arrays.fill(dist, Long.MAX_VALUE);

		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.dist > dist[cur.to]) {
				continue;
			}

			for (Node adj : adjList[cur.to]) {
				long newDist = dist[cur.to] + adj.dist;

				if (newDist >= dist[adj.to]) {
					continue;
				}

				dist[adj.to] = newDist;

				pq.add(new Node(adj.to, newDist));
			}

		}

		if (dist[end] == Long.MAX_VALUE) {
			return Long.MIN_VALUE;
		}
		return dist[end];

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
			return Long.compare(this.dist, o.dist);
		}
	}


}