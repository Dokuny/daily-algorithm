import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int cnt = 0;
	static int N;
	static int S;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(-1, 0);
		System.out.println(cnt);
	}

	static void dfs(int prev, int sum) {
		for (int i = prev + 1; i < N; i++) {
			int calc = sum + arr[i];
			if(calc == S){
				cnt++;
			}


			dfs(i, calc);
		}
	}

}