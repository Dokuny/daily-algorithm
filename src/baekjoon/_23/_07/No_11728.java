package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 23.07.22
 * 투포인터 정렬 문제
 */
public class No_11728 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 배열 받는 부분
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		int[] B = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}


		// 투포인터로 정렬
		int aIdx = 0;
		int bIdx = 0;

		StringBuilder sb = new StringBuilder();

		while (aIdx < N && bIdx < M) {
			if (A[aIdx] < B[bIdx]) {
				sb.append(A[aIdx++])
					.append(" ");
			} else {
				sb.append(B[bIdx++])
					.append(" ");
			}
		}

		// 한쪽이 먼저 끝에 닿을 경우, 나머지 배열의 값들을 집어넣어주는 작업
		for (int i = aIdx; i < N; i++) {
			sb.append(A[i])
				.append(" ");
		}

		for (int i = bIdx; i < M; i++) {
			sb.append(B[i])
				.append(" ");
		}

		System.out.println(sb);
	}

}
