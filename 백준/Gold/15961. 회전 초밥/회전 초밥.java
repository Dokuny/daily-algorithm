import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
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

		int[] conveyor = new int[N];

		int answer = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			conveyor[i] = Integer.parseInt(br.readLine());
		}

		int[] kinds = new int[d + 1];
		
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			if (kinds[conveyor[i]] == 0) {
				cnt++;
			}
			kinds[conveyor[i]]++; 
		}

		int left = 0;
		int right = k - 1;

		while (left < N) {
			
			if (kinds[conveyor[left]] == 1) {
				cnt--;
			}
			kinds[conveyor[left]]--;
			left++;

			right = (right + 1) % N;
			if (kinds[conveyor[right]] == 0) {
				cnt++;
			}
			kinds[conveyor[right]]++;
			
			// 쿠폰이 없으면
			if (kinds[c] == 0) {
				answer = Math.max(cnt+1,answer);
				continue;
			}
			answer = Math.max(cnt, answer);
		}

		System.out.println(answer);
	}

}
