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

		int[] LIS = new int[N];
		Arrays.fill(LIS, Integer.MAX_VALUE);

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			int idx = Arrays.binarySearch(LIS, num);
			if (idx < 0) {
				idx = -(idx + 1);
			}
			LIS[idx] = num;
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			if (LIS[i] == Integer.MAX_VALUE) {
				answer = i;
				break;
			}
		}
		if (answer == 0) answer = N;
		System.out.println(answer);


	}


}