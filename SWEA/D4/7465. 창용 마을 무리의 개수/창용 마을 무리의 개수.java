import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

	static int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	static int[] parents;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			parents = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				parents[i] = i;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				union(a, b);
			}

			HashSet<Integer> set = new HashSet<>();
			for (int i = 1; i <= N; i++) {
				set.add(find(i));
			}


			sb.append("#").append(test_case).append(" ").append(set.size()).append("\n");

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
		if (a == parents[a]) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}


}