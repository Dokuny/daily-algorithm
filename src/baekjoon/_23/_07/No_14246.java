package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 23.07.22
 */
public class No_14246 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		long[] arr = new long[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long k = Long.parseLong(br.readLine());


		int left = 0;
		int right = 0;

		long sum = arr[left];
		long cnt = 0;

		while (left < n && right < n) {
			// 큰값만 있어서 left가 right보다 크게 될 가능성이 존재
			if (left > right) {
				right = left;
				sum = arr[left];
			}

			// 현재 sum 값이 k보다 더 크면 값을 줄여도 되니 줄인다.
			if (sum > k) {
				// 현재 right 기준으로 오른쪽 요소들은 전부 sum보다 크므로 cnt에 추가해준다.
				cnt += n - right;

				// 크니 값을 줄여도 되서 left를 증가시킨다.
				sum -= arr[left++];
			} else {
				// 현재 sum 값이 k보다 작거나 같으면 값을 늘려줘야한다.
				right++;
				// 그런데 right값이 n을 넘어갈 수 도 있으므로 체크해준다.
				if(right >= n) break;

				sum += arr[right];
			}
		}

		System.out.println(cnt);
	}

//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		int n = Integer.parseInt(br.readLine());
//
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		long[] arr = new long[n];
//
//		long sum = 0;
//		for (int i = 0; i < n; i++) {
//			sum += Integer.parseInt(st.nextToken());
//			arr[i] = sum;
//		}
//
//		long k = Long.parseLong(br.readLine());
//
//		long cnt = 0;
//
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] > k) {
//				for (int j = 0; j <= i; j++) {
//					if (arr[i] - arr[j] <= k) {
//						cnt += j + 1;
//						break;
//					}
//				}
//			}
//		}
//
//		System.out.println(cnt);

}

