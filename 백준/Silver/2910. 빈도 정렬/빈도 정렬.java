import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 23.07.30
 */
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		List<Integer>[] arr = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}

		Map<Integer, Integer> map = new LinkedHashMap<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		for (Integer num : map.keySet()) {
			arr[map.get(num)].add(num);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = N; i > 0; i--) {
			for (int j = 0; j < arr[i].size(); j++) {
				Integer num = arr[i].get(j);
				for (int k = 0; k < i; k++) {
					sb.append(num).append(" ");
				}
			}
		}
		System.out.println(sb);

	}


}
