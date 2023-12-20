import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] points = new int[N + 1];

		st = new StringTokenizer(br.readLine());

		// 누적합 계산
		for (int i = 1; i <= N; i++) {
			points[i] = Integer.parseInt(st.nextToken()) + points[i - 1];
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			double avg = (points[end] - points[start - 1]) / (double) (end + 1 - start);

			sb.append(String.format("%.2f", avg)).append("\n");
		}

		System.out.println(sb);
	}

}
