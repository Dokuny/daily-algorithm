package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 23.07.24
 */
public class No_24060 {

	static int cnt = 0;
	static int K;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		mergerSort(arr, 0, arr.length - 1);
		if (cnt < K) {
			System.out.println(-1);
		}
	}


	public static void mergerSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;

			mergerSort(arr, left, mid);
			mergerSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	public static void merge(int[] arr, int l, int m, int r) {
		int start1 = l;
		int start2 = m + 1;

		int[] merge = new int[r - l + 1];
		int idx = 0;
		while (start1 <= m && start2 <= r) {
			if (arr[start1] <= arr[start2]) {
				merge[idx++] = arr[start1++];
			} else {
				merge[idx++] = arr[start2++];
			}
		}

		while (start1 <= m) {
			merge[idx++] = arr[start1++];
		}

		while (start2 <= r) {
			merge[idx++] = arr[start2++];
		}

		idx = 0;
		while (l <= r) {
			cnt++;
			if (cnt == K) {
				System.out.println(merge[idx]);
				return;
			}
			arr[l++] = merge[idx++];
		}
	}

}
