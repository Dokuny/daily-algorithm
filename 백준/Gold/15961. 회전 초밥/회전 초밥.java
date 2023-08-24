import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 접시 수
		int N = Integer.parseInt(st.nextToken());
		// 초밥 가짓 수
		int d = Integer.parseInt(st.nextToken());
		// 연속해서 먹는 접시 수
		int k = Integer.parseInt(st.nextToken());
		// 쿠폰 초밥 번호
		int c = Integer.parseInt(st.nextToken());

		HashSet<Integer> existSushi = new HashSet<>();

		int[] conveyor = new int[N];

		int answer = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			conveyor[i] = Integer.parseInt(br.readLine());
			existSushi.add(conveyor[i]);
		}

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < k; i++) {
			map.put(conveyor[i], map.getOrDefault(conveyor[i], 0) + 1);
		}

		int left = 0;
		int right = k - 1;

		while (left < N) {

			int cnt = 0;

			if (map.get(conveyor[left]) - 1 == 0) {
				map.remove(conveyor[left]);
			} else {
				map.put(conveyor[left], map.get(conveyor[left]) - 1);
			}
			left++;

			right = (right + 1) % N;
			map.put(conveyor[right], map.getOrDefault(conveyor[right], 0) + 1);

			cnt = map.size();

			if (cnt + 1 <= answer) {
				continue;
			}
			// 쿠폰이 없으면
			if (!map.containsKey(c)) {
				cnt++;
			} else {

				// 쿠폰이 왼쪽 오른쪽에 있는지 확인
				int l = (left - 1 + N) % N;
				int r = (right + 1) % N;

				if (!map.containsKey(c)) {
					if (conveyor[l] == c || conveyor[r] == c) {
						cnt++;
					}
				}
			}

			answer = Math.max(cnt, answer);
		}

		System.out.println(answer);
	}

}
