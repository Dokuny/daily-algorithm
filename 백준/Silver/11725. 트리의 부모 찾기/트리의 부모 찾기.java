import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		adjList = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adjList[a].add(b);
			adjList[b].add(a);
		}

		int[] parents = new int[N + 1];
		parents[1] = 1;

		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(1);

		while (!queue.isEmpty()) {

			Integer cur = queue.poll();

			for (Integer adj : adjList[cur]) {
				if (parents[adj] != 0) {
					continue;
				}

				parents[adj] = cur;
				queue.add(adj);
			}
		}

		for (int i = 2; i <= N; i++) {
			sb.append(parents[i]).append("\n");
		}
		System.out.println(sb);
	}
}

