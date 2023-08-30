import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {

	static int[] parents;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		parents = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}

		Edge[] edges = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(edges);

		long weightSum = 0;
		for (int i = 0; i < E; i++) {
			Edge edge = edges[i];
			if (find(edge.from) != find(edge.to)) {
				union(edge.from, edge.to);

				weightSum += edge.weight;
			}
		}
		System.out.println(weightSum);

	}

	static class Edge implements Comparable<Edge> {
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


	static void union(int a, int b) {
		int aP = find(a);
		int bP = find(b);

		if (aP != bP) {
			parents[bP] = aP;
		}
	}

	static int find(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}



}