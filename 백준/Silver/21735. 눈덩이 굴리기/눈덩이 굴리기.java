import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 23.08.03
 */
public class Main {


	static int M;
	static int N;
	static int max = 0;
	static int[] road;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		road = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			road[i] = Integer.parseInt(st.nextToken());
		}

		recur(0,0,1);
		System.out.println(max);

	}

	public static void recur(int x, int time,int size) {
		if (time == M || x == N)  {
			max = Math.max(max, size);
			return;
		}

		recur(x + 1, time + 1, size + road[x + 1]);

		if (x + 2 <= N) {
			recur(x + 2, time + 1, size / 2 + road[x + 2]);
		}
	}
}
