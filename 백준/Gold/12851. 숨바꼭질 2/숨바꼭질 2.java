import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if (N >= K) {
			System.out.println(N - K + "\n1");
			return;
		}

		int[] visited = new int[100001];

		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(N);
		Arrays.fill(visited, Integer.MAX_VALUE);
		visited[N] = 0;

		int time = 0;
		while (!queue.isEmpty()) {

			int size = queue.size();

			boolean isArrived = false;
			int cnt = 0;

			time++;
			for (int i = 0; i < size; i++) {
				Integer cur = queue.poll();

				int[] arr = {cur * 2, cur + 1, cur - 1};

				for (int num : arr) {

					if(num < 0 || num >= visited.length) continue;

					if (visited[num] < time) {
						continue;
					}

					if (num == K) {
						cnt++;
						isArrived = true;
					}else {
						queue.add(num);
						visited[num] = time;
					}


				}


			}
			if (isArrived) {
				System.out.println(time + "\n" + cnt);
				break;
			}
		}
	}

}