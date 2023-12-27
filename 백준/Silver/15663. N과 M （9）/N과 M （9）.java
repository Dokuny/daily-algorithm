import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	static int M;
	static LinkedHashSet<String> set;
	static int[] selected;
	static int[] arr;
	static int N;

	static StringBuilder sb;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		visited = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		set = new LinkedHashSet<>();

		sb = new StringBuilder();
		selected = new int[M];

		comb(0);

		for (String s : set) {
			sb.append(s).append("\n");
		}

		System.out.println(sb);
		
	}

	static void comb(int depth) {
		if (depth == M) {

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < M; i++) {
				sb.append(selected[i]).append(" ");
			}

			set.add(sb.toString());

			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			selected[depth] = arr[i];
			comb(depth + 1);

			visited[i] = false;
		}

	}

}