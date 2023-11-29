import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import sun.security.util.PendingException;

public class Main {

	static int N;
	static ArrayList<Node>[] adjList;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 학생 수
		int M = Integer.parseInt(st.nextToken()); // 도로 수
		int X = Integer.parseInt(st.nextToken()); // 파티를 할 마을

		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			adjList[from].add(new Node(to, time));
		}

		int max = Integer.MIN_VALUE;
		int[] xDist = dijkstra(X);

		for (int i = 1; i <= N; i++) {

			int dist = dijkstra(i)[X] + xDist[i];

			max = Math.max(max, dist);
		}

		System.out.println(max);
	}

	static int[] dijkstra(int start) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if(dist[cur.to] < cur.dist) continue;

			for (Node adj : adjList[cur.to]) {
				int newDist = dist[cur.to] + adj.dist;

				if (dist[adj.to] > newDist) {
					dist[adj.to] = newDist;

					pq.add(new Node(adj.to, newDist));
				}
			}
		}

		return dist;
	}

	static class Node implements Comparable<Node>{
		int to;
		int dist;

		public Node(int to, int dist) {
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(dist, o.dist);
		}
	}



}

