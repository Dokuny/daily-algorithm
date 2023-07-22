package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 23.07.22
 */
public class No_6359 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		// 사실 입출력 보고 대충 이럴 것 같아서 돌렸는데 성공..

		// 약수 중 2*2처럼 동일한 수가 두번 나오는 경우엔 열림 - 1,2,4 (4의 예시)
		// 합성수이기 때문에 나머지는 닫히는거 - 1,2,3,6 (6의 예시)
		// 그렇다면 그냥 인덱스 돌면서 제곱이 포함되는 범위를 체크
		// 결과적으로는 제곱근 n이 최대로 가질 수 있는 범위
		// 1 - 1 / 2 - 1 / 3 - 1 / 4 - 2 / 5 - 2 / 6 - 2 / 7 - 2 / 8 - 2 / 9 - 3 /

		for (int i = 0; i < T; i++) {
			System.out.println((int)Math.sqrt(Integer.parseInt(br.readLine())));
		}
	}

}
