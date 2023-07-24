package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 23.07.24
 */
public class No_1021 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Deque<Integer> lDeque = new ArrayDeque<>();
		Deque<Integer> rDeque = new ArrayDeque<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());


		for (int i = 1; i <= N; i++) {
			lDeque.addLast(i);
			rDeque.addLast(i);
		}

		int answer = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {

			int lCnt = 0;

			int rCnt = 0;

			int target = Integer.parseInt(st.nextToken());

			while (true) {
				// 현재 덱 앞이 타겟인지 확인
				if (lDeque.peekFirst() == target) {
					lDeque.pollFirst();
					break;
				}
				// 왼쪽으로 한칸 이동
				lDeque.addLast(lDeque.pollFirst());
				lCnt++;
			}

			while (true) {
				if (rDeque.peekFirst() == target) {
					rDeque.pollFirst();
					break;
				}

				rDeque.addFirst(rDeque.pollLast());
				rCnt++;
			}

			answer += Math.min(lCnt, rCnt);
		}
		System.out.println(answer);

	}
}
