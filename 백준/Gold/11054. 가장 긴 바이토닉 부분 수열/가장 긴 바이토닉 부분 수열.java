import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 최장 부분 수열 구하기
 * 이진탐색을 이용해서 구할 수 있음
 */
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] original = new int[N];

		int[] base = new int[N];
		int[] forward = new int[N];
		Arrays.fill(base, Integer.MAX_VALUE);
		int[] backward = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < original.length; i++) {
			original[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < original.length; i++) {
			int cur = original[i];

			int idx = Arrays.binarySearch(base, cur);

			if (idx < 0) {
				idx = -(idx + 1);
			}

			forward[i] = idx+1;
			base[idx] = cur;
		}

		Arrays.fill(base, Integer.MAX_VALUE);
		for (int i = original.length - 1; i >= 0; i--) {
			int cur = original[i];

			int idx = Arrays.binarySearch(base, cur);
			if (idx < 0) {
				idx = -(idx + 1);
			}

			backward[i] = idx+1;
			base[idx] = cur;
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(forward[i] + backward[i], max);
		}
		System.out.println(max-1);
	}
}