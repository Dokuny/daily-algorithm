import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] result = new int[N + 1][2];

		StringTokenizer st;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int aTime = Integer.parseInt(st.nextToken());
			int bTime = Integer.parseInt(st.nextToken());
			int aToB = Integer.parseInt(st.nextToken());
			int bToA = Integer.parseInt(st.nextToken());


			// 0 -> a , 1 -> b
			result[i][0] += aTime;
			result[i][1] += bTime;

			result[i + 1][0] += Math.min(result[i][0], result[i][1] + bToA);
			result[i + 1][1] += Math.min(result[i][1], result[i][0] + aToB);
		}

		st = new StringTokenizer(br.readLine());

		System.out.println(Math.min(result[N][0] + Integer.parseInt(st.nextToken()),
			result[N][1] + Integer.parseInt(st.nextToken())));

	}

}
