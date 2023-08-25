import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] trees = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(trees);

		// 이진탐색 이용
		int left = 1;
		int right = trees[N - 1];

		while (left < right) {
			int mid = (left + right) / 2;

			long cnt = 0;
			for (int i = trees.length - 1; i >= 0; i--) {
				if(trees[i] <= mid) break;

				cnt += trees[i] - mid;
			}

			// 목표 길이보다 짧다면 나무를 더 짧게 베어야 한다.
			if (cnt < M) {
				right = mid;
			} else { // 목표 길이보다 길거나 같다면 나무를 높게 베어야 한다.
				left = mid+1;
			}
		}

		System.out.println(left - 1);
	}


}