import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Solution {

	static int[] parents;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder result = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {

			st = new StringTokenizer(br.readLine());

			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			parents = new int[V + 1];
			for (int i = 1; i <= V; i++) {
				parents[i] = i;
			}

			ArrayList<Edge> edges = new ArrayList<>();
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				edges.add(new Edge(a, b, c));
				edges.add(new Edge(b, a, c));
			}
			edges.sort(Comparator.comparingInt(o -> o.w));

			long weightSum = 0;
			for (int i = 0; i < edges.size(); i++) {
				Edge edge = edges.get(i);
				if (find(edge.a) != find(edge.b)) {
					union(edge.a, edge.b);
					weightSum += edge.w;
				}
			}
			result.append("#").append(test_case).append(" ").append(weightSum).append("\n");
		}
		System.out.println(result);
	}

	static class Edge {

		int a;
		int b;
		int w;

		public Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
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