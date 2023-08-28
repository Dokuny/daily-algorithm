import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

class Main {

	static int N;
	static int[] roman = {1, 5, 10, 50};
	static int[] selected;
	static boolean[] visited;
	static HashSet<Integer> set = new HashSet<>();

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 조합으로 풀기
		N = Integer.parseInt(br.readLine());
		selected = new int[N];
		visited = new boolean[N];

		for (int i = 0; i < 4; i++) {
			comb(i, 0);
		}

		System.out.println(set.size());

	}

	static void comb(int prev, int depth) {
		if (depth == N) {
			int sum = 0;
			for (int n : selected) {
				sum += roman[n];
			}
			set.add(sum);
			return;
		}

		for (int i = prev; i < 4; i++) {
			selected[depth] = i;
			comb(i, depth + 1);
		}
	}

}