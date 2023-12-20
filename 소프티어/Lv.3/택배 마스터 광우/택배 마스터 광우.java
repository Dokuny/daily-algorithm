import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int M;
	static int K;
	static int N;
	static boolean[] visited;
	static int[] selected;
	static int[] arr;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N];
		visited = new boolean[N];
		selected = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0);

		System.out.println(min);

	}

	static void dfs(int depth) {
		if (depth == N) {

			int idx = 0;
			int sum = 0;
			for (int i = 0; i < K; i++) {

				int weight = 0;

				while (weight <= M) {
					if (idx == N) {
						idx = 0;
					}

					weight += selected[idx];
					if (weight > M) {
						weight -= selected[idx];
						break;
					}
					idx++;
				}
				sum += weight;

				if(sum >= min) return;
			}

			min = Math.min(sum, min);
			return;
		}

		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;

			visited[i] = true;
			selected[depth] = arr[i];
			dfs(depth + 1);

			visited[i] = false;
		}
	}
}
