import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int cnt;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			cnt = 0;
			int N = Integer.parseInt(br.readLine());

			dfs(N);
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
		
	}

	static void dfs(int remain) {
		if (remain == 0) {
			cnt++;
			return;
		}

		for (int i = 1; i <= Math.min(remain, 3); i++) {
			dfs(remain - i);
		}
	}
}