import com.sun.javafx.geom.Edge;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

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

			Set<Integer> no = new HashSet<>();
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());

				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());

				edges.add(new Edge(S, E, -T));
				no.add(E);
			}

			boolean isCycle = false;

			for (Integer n : no) {
				long[] dist = new long[N + 1];
				Arrays.fill(dist, Long.MAX_VALUE);
				dist[n] = 0;

				for (int i = 0; i < N + 1; i++) {
					for (int j = 0; j < edges.size(); j++) {
						Edge cur = edges.get(j);

						if (dist[cur.from] == Long.MAX_VALUE)
							continue;

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

				if (isCycle) {
					sb.append("YES").append("\n");
					break;
				}
			}
			if (!isCycle) {
				sb.append("NO").append("\n");
			}
		}
		System.out.println(sb);
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

