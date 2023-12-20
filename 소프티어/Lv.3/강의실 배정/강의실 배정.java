import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(value -> value[1]));
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		// 가장 일찍 끝나는거
		int cnt = 0;

		int[] prev = {0, 0};
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			if(cur[0] < prev[1]) continue;

			cnt++;
			prev = cur;
		}
		System.out.println(cnt);
	}
}
