import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 정점 수
		int N = Integer.parseInt(st.nextToken());
		// 이동 가능 거리
		int M = Integer.parseInt(st.nextToken());
		// 간선 수
		int R = Integer.parseInt(st.nextToken());

		int[] items = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}

		// 플로이드 워셜
		int[][] map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE);
			map[i][i] = 0;
		}

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			map[a][b] = d;
			map[b][a] = d;
		}

		for (int m = 1; m <= N; m++) {
			for (int s = 1; s <= N; s++) {
				for (int e = 1; e <= N; e++) {
					if(map[s][m] == Integer.MAX_VALUE || map[m][e] == Integer.MAX_VALUE) continue;

					map[s][e] = Math.min(map[s][e], map[s][m] + map[m][e]);
				}
			}
		}

		int max = 0;

		for (int i = 1; i <= N; i++) {

			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				if (map[i][j] <= M) {
					cnt += items[j];
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}

	static class Node implements Comparable<Node> {

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