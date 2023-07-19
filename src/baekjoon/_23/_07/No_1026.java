package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 23.07.19
 */
public class No_1026 {

	public static void main(String[] args) throws IOException {

// 입력 코드
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Integer[] A = new Integer[N];
		Integer[] B = new Integer[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

// 정렬 및 역정렬 - 가장 큰값과 가장 작은 값을 곱해야 작은 수가 나옴
		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += A[i] * B[i];
		}

		System.out.println(sum);

	}

}
