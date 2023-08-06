import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] dists = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					continue;
				}
				dists[i][j] = Integer.MAX_VALUE;
			}
		}

		Edge[] edges = new Edge[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i] = new Edge(Integer.parseInt(st.nextToken()) - 1,
				Integer.parseInt(st.nextToken()) - 1,
				1);
		}

		for (Edge edge : edges) {
			dists[edge.from][edge.to] = edge.dist;
			dists[edge.to][edge.from] = edge.dist;
		}

		for (int mid = 0; mid < N; mid++) {
			for (int start = 0; start < N; start++) {
				for (int end = 0; end < N; end++) {
					if (dists[start][mid] != Integer.MAX_VALUE
						&& dists[mid][end] != Integer.MAX_VALUE) {
						dists[start][end] = Math.min(dists[start][end],
							dists[start][mid] + dists[mid][end]);
					}
				}
			}
		}

		int minIdx = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if(dists[i][j] == Integer.MAX_VALUE) continue;
				sum += dists[i][j];
			}

			if (min > sum) {
				min = sum;
				minIdx = i;
			}
		}

		System.out.println(minIdx+1);


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