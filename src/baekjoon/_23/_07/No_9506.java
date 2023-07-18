package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class No_9506 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n;

		StringBuilder sb = new StringBuilder();

		while ((n = Integer.parseInt(br.readLine())) != -1) {

			int sum = 1;

			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {

					pq.add(i);
					sum += i;
					int other = n / i;
					if (other == i) {
						continue;
					}
					pq.add(other);
					sum += other;
				}
			}

			if (sum != n) {
				sb.append(n)
					.append(" is NOT perfect.")
					.append("\n");
			} else {
				sb.append(n)
					.append(" = 1");
				while (!pq.isEmpty()) {
					sb.append(" + ")
						.append(pq.poll());
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
