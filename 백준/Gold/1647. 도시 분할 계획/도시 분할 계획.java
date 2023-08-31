import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Main {

	static int[][] dirs = {{-1, 0}, {-1, -1}, {0, -1}};
	static int N;
	static int M;


	static Edge[] edges;
	static int[] parents;
	static int answer = Integer.MIN_VALUE;


	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		edges = new Edge[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			edges[i] = new Edge(a, b, w);
		}

		Arrays.sort(edges);

		int totalSum = 0;
		for (int i = 0; i < M; i++) {
			Edge edge = edges[i];
			if (union(edge.from, edge.to)) {
				totalSum += edge.weight;
				answer = Math.max(edge.weight, answer);
			}
		}

		System.out.println(totalSum - answer);
	}

	static boolean union(int a, int b) {
		int aP = find(a);
		int bP = find(b);

		if (aP != bP) {
			parents[bP] = aP;
			return true;
		}
		return false;
	}

	static int find(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	static class Edge implements Comparable<Edge>{

		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}