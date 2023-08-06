import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 플로이드 워셜 문제
		int[][] distance = new int[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				distance[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int m = 0; m < N; m++) {
			for (int s = 0; s < N; s++) {
				for (int e = 0; e < N; e++) {
					if (distance[s][m] != 0
						&& distance[m][e] != 0) {
						distance[s][e] = 1;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(distance[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}