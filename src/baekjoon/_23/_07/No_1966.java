package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 23.07.22
 */
public class No_1966 {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] pages = new int[N];
			int[] priorities = new int[10];

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int priority = Integer.parseInt(st.nextToken());
				pages[j] = priority;
				priorities[priority]++;
			}

			int seq = 0;
			int pointer = 0;

			boolean isFinished = false;
			for (int j = 9; j >= 1; j--) {

				while (priorities[j] != 0) {

					if (pages[pointer] == j) {
						seq++;
						priorities[j]--;
						if (pointer == M) {
							System.out.println(seq);
							isFinished = true;
							break;
						}
					}

					pointer = (pointer + 1) % N;
				}
				if(isFinished) break;
			}


		}

	}

	// 큐 사용버전 - 굳이 큐 사용안해도 될 듯?
	public static void main2(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;

		Queue<Page> queue;

		// T = 테스트 케이스 수
		for (int i = 0; i < T; i++) {

			// 입력값 받기
			st = new StringTokenizer(br.readLine());

			// N = 문서의 개수
			int N = Integer.parseInt(st.nextToken());
			// M = 궁금한 문서의 인덱스
			int M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			// 각 우선순위별로 몇개가 있는지 체크할 배열
			int[] points = new int[10];
			// 큐 자료구조 선언
			queue = new LinkedList<>();

			for (int j = 0; j < N; j++) {
				int point = Integer.parseInt(st.nextToken());
				queue.add(new Page(j, point)); // 큐에 Page 넣기
				points[point]++; // 우선순위 개수 체크
			}

			// 출력이 몇번 이루어졌는지 카운트 해주는 변수
			int seq = 0;

			// 우선순위 최대가 9이기 때문에 9 -> 1순으로 순회
			for (int j = 9; j >= 1; j--) {
				// 해당 우선순위를 가지는 페이지가 없는 경우, continue
				if (points[j] == 0) {
					continue;
				}

				// 궁금한 페이지의 출력 순서가 오면 반복문 종료를 해주기 위한 플래그 변수
				boolean isFinished = false;

				// 카운팅 정렬처럼 해당 우선순위에 있는 페이지들을 전부 출력
				while (points[j] != 0) {
					// 큐에서 꺼낸 페이지
					Page cur = queue.poll();

					// 현재 페이지의 우선순위가 반복문으로 돌고 있는 현재 우선순위와 동일한 경우
					if (cur.point == j) {
						points[j]--; // 페이지 개수 하나 제거(출력)
						seq++; // 출력 순서 증가

						// 만약, 출력한 페이지가 내가 궁금했던 페이지라면
						if (cur.idx == M) {
							System.out.println(seq); // 결과값 출력
							isFinished = true; // while문 바깥 반복문(우선순위 for문)을 종료하기 위해 true
							break;
						}
					} else {
						// 현재 페이지의 우선순위가 반복문으로 돌고 있는 현재 우선순위와 동일하지 않은 경우(우선순위가 작은 경우)
						// 다시 queue에 넣어주기
						queue.add(cur);
					}
				}
				// 반복문 종료
				if (isFinished) {
					break;
				}
			}
		}

	}

	// 페이지의 정보를 담을 클래스
	static class Page {

		public int idx; // 들어온 순서
		public int point; // 우선순위

		public Page(int idx, int point) {
			this.idx = idx;
			this.point = point;
		}
	}
}
