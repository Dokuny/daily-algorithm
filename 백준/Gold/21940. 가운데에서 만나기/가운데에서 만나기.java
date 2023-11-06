import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] dist = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		for (int i = 1; i <= N; i++) {
			dist[i][i] = 0;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			dist[a][b] = t;
		}

		for (int m = 1; m <= N ; m++) {
			for (int s = 1; s <= N ; s++) {
				for (int e = 1; e <= N; e++) {
					if (dist[s][m] != Integer.MAX_VALUE && dist[m][e] != Integer.MAX_VALUE) {
						dist[s][e] = Math.min(dist[s][e], dist[s][m] + dist[m][e]);
					}
				}
			}
		}

		int K = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		int[] people = new int[K];
		for (int i = 0; i < K; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}


		int min = Integer.MAX_VALUE;
		int[] answer = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int max = Integer.MIN_VALUE;

			boolean isPossible = true;
			for (int person : people) {
				if (dist[i][person] == Integer.MAX_VALUE || dist[person][i] == Integer.MAX_VALUE) {
					isPossible = false;
					break;
				}

				max = Math.max(max, dist[i][person] + dist[person][i]);
			}

			if(!isPossible) continue;

			answer[i] = max;
			min = Math.min(min, max);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (answer[i] == min) {
				sb.append(i).append(" ");
			}
		}

		System.out.println(sb);


	}

}