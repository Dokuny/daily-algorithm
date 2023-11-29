import com.sun.javafx.geom.Edge;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static int[] parents;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= testCase; test_case++) {

			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); // 지점 수
			int M = Integer.parseInt(st.nextToken()); // 도로 수
			int W = Integer.parseInt(st.nextToken()); // 웜홀 수

			ArrayList<Edge> edges = new ArrayList<>();

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());

				edges.add(new Edge(S, E, T));
				edges.add(new Edge(E, S, T));

			}

			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());

				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());

				edges.add(new Edge(S, E, -T));
			}

			parents = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				parents[i] = i;
			}

			for (Edge edge : edges) {
				union(find(edge.from), find(edge.to));
			}

			HashSet<Integer> set = new HashSet<>();

			for (int i = 1; i <= N; i++) {
				set.add(parents[i]);
			}

			boolean isCycle = false;

			for (Integer no : set) {
				long[] dist = new long[N + 1];
				Arrays.fill(dist, Long.MAX_VALUE);
				dist[no] = 0;


				for (int i = 0; i < N + 1; i++) {
					for (int j = 0; j < edges.size(); j++) {
						Edge cur = edges.get(j);

						if(dist[cur.from] == Long.MAX_VALUE) continue;

						long newDist = dist[cur.from] + cur.dist;

						if (dist[cur.to] > newDist) {
							dist[cur.to] = newDist;

							if (i == N) {
								isCycle = true;
								break;
							}
						}
					}
				}

				if(isCycle) break;
			}

			if (isCycle) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}


		}
		System.out.println(sb);
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

	static class Edge {
		int from;
		int to;
		int dist;

		public Edge(int from, int to, int dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
	}

}

