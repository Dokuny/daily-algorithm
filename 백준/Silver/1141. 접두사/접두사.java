import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<String> pq = new PriorityQueue<>(
			(o1, o2) -> {
				return o2.length() - o1.length();
			});



		for (int i = 0; i < N; i++) {
			pq.add(br.readLine());
		}

		ArrayList<String> list = new ArrayList<>();
		list.add(pq.poll());


		while (!pq.isEmpty()) {
			String poll = pq.poll();

			boolean isAdd = true;
			for (String s : list) {
				if (s.startsWith(poll)) {
					isAdd = false;
					continue;
				}
			}
			if (isAdd) {
				list.add(poll);
			}
		}

		System.out.println(list.size());
	}
}