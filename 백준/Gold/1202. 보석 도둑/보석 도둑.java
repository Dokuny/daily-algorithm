import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] adjList;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Jewel[] arr = new Jewel[N];
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(arr, Comparator.comparingInt(jewel -> jewel.weight));

		int[] bagWeight = new int[K];
		for (int i = 0; i < K; i++) {
			bagWeight[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(bagWeight);

		long sum = 0;
		int idx = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < K; i++) {
			// 가방 크기만큼 pq에 담기
			while (idx < N && arr[idx].weight <= bagWeight[i]) {
				pq.add(arr[idx].value);
				idx++;
			}

			if (!pq.isEmpty()) {
				sum += pq.poll();
			}
		}

		System.out.println(sum);
	}

	static class Jewel {

		int weight;
		int value;

		public Jewel(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}


}
