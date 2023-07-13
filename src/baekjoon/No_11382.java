package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_11382 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 만약, Long 범위를 초과하는 경우
		String A = st.nextToken();
		String B = st.nextToken();
		String C = st.nextToken();

		// 계산한 결과를 저장할 배열
		char[] answer = new char[Math.max(A.length(),Math.max(B.length(),C.length())) + 1];

		// A,B,C의 길이가 다 다르기 때문에 1의 자리수부터 따라가기 위한 변수 선언
		int aIdx = A.length() - 1;
		int bIdx = B.length() - 1;
		int cIdx = C.length() - 1;

		// 각 자리의 합이 10을 넘기는 경우 다음 자리로 넘겨줘야하는 수
		int next = 0;

		// answer 배열의 인덱스를 따라갈 수
		int idx = answer.length - 1;
		while (aIdx > -1 || bIdx > -1 || cIdx > -1) {
			int a = aIdx >= 0 ? A.charAt(aIdx) - '0' : 0;
			int b = bIdx >= 0 ? B.charAt(bIdx) - '0' : 0;
			int c = cIdx >= 0 ? C.charAt(cIdx) - '0' : 0;

			int sum = a + b + c + next;

			next = sum / 10;
			answer[idx--] = (char) (sum % 10 + '0');

			aIdx--;
			bIdx--;
			cIdx--;
		}

		if (next != 0) {
			answer[idx--] = (char) (next + '0');
		}

		StringBuilder sb = new StringBuilder();
		for (int i = idx + 1; i < answer.length; i++) {
			sb.append(answer[i]);
		}

		System.out.println(sb);
	}

}
