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
		int E = Integer.parseInt(br.readLine());

		ArrayList<Node>[] adjList = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}

		StringTokenizer st;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int arrive = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			adjList[start].add(new Node(arrive, cost));
		}

		st = new StringTokenizer(br.readLine());

		int origin = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(origin, 0));

		long[] dist = new long[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[origin] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if(dist[cur.to] < cur.dist) continue;

			for (Node adj : adjList[cur.to]) {
				long newDist = dist[cur.to] + adj.dist;
				if (newDist < dist[adj.to]) {
					dist[adj.to] = newDist;
					pq.add(new Node(adj.to, newDist));
				}
			}
		}

		System.out.println(dist[target]);
	}

	static class Node implements Comparable<Node>{
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

