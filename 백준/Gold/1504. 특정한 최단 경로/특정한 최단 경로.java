import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static ArrayList<Node>[] adjList;
	static int V;
	static int E;

	static long answer = Long.MAX_VALUE;
	static boolean[] visited;

	static long[][] distances;

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

		Set<Integer> set = new LinkedHashSet<>();
		set.add(0);
		set.add(a);
		set.add(b);
		set.add(V - 1);

		ArrayList<Integer> list = new ArrayList<>(set);

		// start , a, b, end  다익스트라로 거리구한 후
		// 4개를 간선 리스트로 만들고 최소신장 트리 ㄱㄱ

		distances = new long[set.size()][V];

		for (int i = 0; i < set.size(); i++) {
			distances[i] = dijkstra(list.get(i), V);
		}

		adjList = new ArrayList[set.size()];

		for (int i = 0; i < set.size(); i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < list.size(); i++) {

			for (int j = 0; j < list.size(); j++) {
				if (i == j) {
					continue;
				}
				if (distances[i][list.get(j)] == Long.MAX_VALUE || distances[i][list.get(j)] == 0) {
					continue;
				}

				long dist = distances[i][list.get(j)];

				adjList[i].add(new Node(j, dist));
			}
		}

		for (int i = 0; i < set.size(); i++) {
			distances[i] = dijkstra(i, set.size());
		}

		visited = new boolean[list.size()];
		visited[0] = true;

		comb(0, 0, set.size() - 1, 0, 0);

		System.out.println(answer == Long.MAX_VALUE ? -1 : answer < 0 ? -1 : answer);

	}

	static void comb(int depth, int start, int end, long sum ,int prev) {
		if (depth == end - start - 1) {
			answer = Math.min(sum + distances[prev][end], answer);
			return;
		}

		for (int i = start + 1; i < end; i++) {
			if(visited[i]) continue;
			if(distances[prev][i] == Long.MAX_VALUE || distances[prev][i] == 0) continue;
			visited[i] = true;
			comb(depth + 1, start, end, sum + distances[prev][i], i);
			visited[i] = false;
		}
	}

	static long[] dijkstra(int start, int size) {

		long[] distances = new long[size];
		Arrays.fill(distances, Long.MAX_VALUE);
		distances[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(v -> v.dist));

		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.dist > distances[cur.to]) {
				continue;
			}

			for (Node adj : adjList[cur.to]) {
				long newDist = distances[cur.to] + adj.dist;

				if (distances[adj.to] > newDist) {
					distances[adj.to] = newDist;
					pq.add(new Node(adj.to, newDist));
				}
			}
		}

		return distances;
	}

	static class Node {

		int to;
		long dist;

		public Node(int to, long dist) {
			this.to = to;
			this.dist = dist;
		}
	}


}