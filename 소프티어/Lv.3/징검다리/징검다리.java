import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N];
		Arrays.fill(dp, Integer.MAX_VALUE);

		for (int i = 0; i < N; i++) {
			int num = Arrays.binarySearch(dp, arr[i]);

			if (num < 0) {
				num = -(num + 1);
			}

			dp[num] = arr[i];
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (dp[i] == Integer.MAX_VALUE) {
				break;
			}

			cnt++;
		}

		System.out.println(cnt);

	}

}
