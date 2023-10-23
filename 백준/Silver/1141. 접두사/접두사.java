import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String[] arr = new String[N];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}

		Arrays.sort(arr);

		int answer = 0;
		for (int i = 1; i < N; i++) {
			if (!arr[i].startsWith(arr[i - 1])) {
				answer++;
			}
		}

		System.out.println(answer+1);
	}
}