import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int M;
	static StringBuilder sb;
	static int[] selected;
	static int[] arr;
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		sb = new StringBuilder();
		selected = new int[M];
		
		comb(0 , 0);

		System.out.println(sb);
		
	}

	static void comb(int depth, int prev) {
		if (depth == M) {

			for (int i = 0; i < M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = prev; i < N; i++) {
			selected[depth] = arr[i];
			comb(depth + 1, i);
		}

	}

}