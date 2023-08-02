import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 23.07.30
 */
public class Main {

	static int N;
	static int min = Integer.MAX_VALUE;
	static boolean[] visited;
	static int[][] map;


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		visited = new boolean[N];
		map = new int[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		recur(0, 0, 0);

		System.out.println(min);

	}

	public static void recur(int cur, int depth, int sum) {
		if (depth == N) {
			min = Math.min(min, sum);
			return;
		}

		visited[cur] = true;

		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			if(map[cur][i] == 0) continue;

			recur(i, depth + 1, sum + map[cur][i]);
		}

		visited[cur] = false;

		if (depth == N - 1 && map[cur][0] != 0) {
			recur(cur, depth + 1, sum + map[cur][0]) ;
		}
	}

}
