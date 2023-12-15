import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Node>[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adjList[s].add(new Node(e, c));
		}

		long[] dist = new long[N + 1];
		Arrays.fill(dist, Long.MAX_VALUE);

		st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(start, 0));

		int[] order = new int[N + 1];
		order[start] = start;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if(dist[cur.to] < cur.dist) continue;

			for (Node adj : adjList[cur.to]) {

				long newDist = dist[cur.to] + adj.dist;

				if (newDist < dist[adj.to]) {
					dist[adj.to] = newDist;
					pq.add(new Node(adj.to, dist[adj.to]));
					order[adj.to] = cur.to;
				}
			}
		}

		StringBuilder temp = new StringBuilder();

		int cnt = 0;

		int s = end;
		while (true) {
			temp.insert(0, s + " ");
			cnt++;
			if(s == start) break;

			s = order[s];
		}

		StringBuilder sb = new StringBuilder();
		sb.append(dist[end]).append("\n")
			.append(cnt).append("\n")
			.append(temp);

		System.out.println(sb);
	}

	static class Node implements Comparable<Node>{
		int to;
		long dist;
		int prev;

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

