import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Node>[] adjList;
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		StringTokenizer st;

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adjList[a].add(new Node(b, w));
			adjList[b].add(new Node(a, w));
		}

		int[] first = dijkstra(1);

		int maxIdx = findMaxIdx(first);

		int[] result = dijkstra(maxIdx);

		System.out.println(result[findMaxIdx(result)]);
	}

	static int findMaxIdx(int[] arr) {
		int max = Integer.MIN_VALUE;
		int idx = -1;
		for (int i = 1; i <= N; i++) {
			if (max < arr[i]) {
				max = arr[i];
				idx = i;
			}
		}
		return idx;
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