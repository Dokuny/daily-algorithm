import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * 다익스트라 + 유니온 파인드
 * 다익스트라로 경로 찾으면서 유니온 파인드로 경로표 구하기
 */
class Main {

	static ArrayList<Node>[] adjList;
	static int[][] parents;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 다익스트라
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		// 거리 초기화
		int[][] distances = new int[V + 1][V + 1];
		for (int i = 1; i <= V; i++) {
			Arrays.fill(distances[i], Integer.MAX_VALUE);
			distances[i][i] = 0;
		}

		// 인접 리스트 초기화
		adjList = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}

		// 인접 리스트 값 넣기
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjList[from].add(new Node(to, weight));
			adjList[to].add(new Node(from, weight));
		}

		// 기록할 녀석
		parents = new int[V + 1][V + 1];

		// 다익스트라 돌리기
		for (int i = 1; i <= V; i++) {

			// parents 배열 초기화
			for (int j = 1; j <= V; j++) {
				if(i == j) parents[i][j] = 0;
				else parents[i][j] = j;
			}

			PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(v->v.weight));
			pq.add(new Node(i, 0));
			
			while (!pq.isEmpty()) {
				Node cur = pq.poll();

				if (cur.weight > distances[i][cur.to]) {
					continue;
				}

				for (Node adj : adjList[cur.to]) {
					int newDist = distances[i][cur.to] + adj.weight;

					if (newDist < distances[i][adj.to]) {
						distances[i][adj.to] = newDist;

						pq.add(new Node(adj.to, newDist));

						parents[i][adj.to] = adj.to;

						if (cur.to != i) {
							union(cur.to, adj.to, parents[i]);
						}
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (i == j) {
					sb.append("-");
				}else {
					sb.append(parents[i][j]);
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);


	}

	static void union(int a, int b, int[] parent) {
		int aP = find(a, parent);
		int bP = find(b, parent);

		if (aP != bP) {
			parent[bP] = aP;
		}
	}

	static int find(int a, int[] parent) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a], parent);
	}

	static class Node {

		int to;
		int weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}


}