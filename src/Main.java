import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] coins = {25, 10, 5, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int cur = Integer.parseInt(br.readLine());


			for (int j = 0; j < 4; j++) {
				sb.append(cur / coins[j])
					.append(" ");
				cur %= coins[j];
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
