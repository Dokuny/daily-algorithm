import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		if (N == 0) {
			System.out.println(0);
			return;
		}


		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int sum = 0;
		int cnt = 0;
		int v = (int)Math.round(N * 0.15);
		for (int i = v; i < arr.length - v; i++) {
			sum += arr[i];
			cnt++;
		}

		System.out.println(Math.round((float) sum / cnt));
	}
}

