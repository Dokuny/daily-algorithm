import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static HashMap<Integer, Integer> countMap;
	static PriorityQueue<Integer> minHeap;
	static PriorityQueue<Integer> maxHeap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());

			minHeap = new PriorityQueue<>();
			maxHeap = new PriorityQueue<>(Collections.reverseOrder());

			countMap = new HashMap<>();

			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());

				String command = st.nextToken();
				int n = Integer.parseInt(st.nextToken());

				if (command.equals("I")) {
					minHeap.add(n);
					maxHeap.add(n);
					countMap.put(n, countMap.getOrDefault(n, 0) + 1);
				} else {
					// 최대값 삭제
					if (n == 1) {
						remove(maxHeap);
					} else { // 최소값 삭제
						remove(minHeap);
					}
				}
			}

			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;

			for (Integer key : countMap.keySet()) {
				max = Math.max(max, key);
				min = Math.min(min, key);
			}

			if (countMap.isEmpty()) {
				sb.append("EMPTY");
			} else {
				sb.append(max).append(" ").append(min);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void remove(PriorityQueue<Integer> heap) {
		while (!heap.isEmpty()) {
			Integer poll = heap.poll();

			if (!countMap.containsKey(poll)) {
				continue;
			}

			if (countMap.get(poll) == 1) {
				countMap.remove(poll);
			} else {
				countMap.put(poll, countMap.get(poll) - 1);
			}
			break;
		}
	}

}