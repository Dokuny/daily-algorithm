import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 23.07.26
 */
public class Main {

	static boolean[] visited;
	static int N;
	static int M;

	static char[] chars;
	static StringBuilder sb;
	static int idx;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];
		chars = new char[M];
		sb = new StringBuilder();

		recur(0,1);

		System.out.println(sb);
	}

	public static void recur(int depth,int a) {
		if (depth == M) {
			for (int i = 0; i < chars.length; i++) {
				sb.append(chars[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = a; i <= N; i++) {
			chars[depth] = (char)('0' + i);
			recur(depth + 1, i);
		}
	}


}
