import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = 0;

		long sum = arr[left];

		int length = Integer.MAX_VALUE;

		while (left < N && right < N) {
			if (sum == S) {
				length = Math.min(length, right - left + 1);
				sum -= arr[left++];
				if (++right == N) {
					break;
				}
				sum += arr[right];
			} else if (sum < S) {
				if (++right == N) {
					break;
				}
				sum += arr[right];
			} else {
				length = Math.min(length, right - left + 1);
				sum -= arr[left++];
			}
		}

		if (length == Integer.MAX_VALUE) {
			length = 0;
		}
		System.out.println(length);
	}

}