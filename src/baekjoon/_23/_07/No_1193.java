package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1193 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int sum = 0;

		// 대각선 줄 인덱스
		int i = 1;
		// 대각선(/)으로 한줄씩 보았을 때, 1,2,3,4,5... 이런식으로 갯수가 늘어남
		// 만약 주어진 수가 각 줄의 합보다 작은 경우에 그 줄에 포함된다고 볼 수 있음
		while (sum < N) {
			sum += i;
			i++;
		}
		i -= 1; // 1이 항상 추가되므로 빼주어야 한다.

		// 주어진 수가 끝에서부터 얼마나 떨어져있는지 계산
		int diff = sum - N;

		boolean isOdd;
		if (i % 2 == 0) {
			isOdd = false;
		} else {
			isOdd = true;
		}

		StringBuilder sb = new StringBuilder();

		// 홀수 인덱스의 경우, 우상단이 끝
		if (isOdd) {
			sb.append(1 + diff)  // 차이만큼 증가
				.append("/")
				.append(i - diff); // 차이만큼 감소
		} else { // 짝수 인덱스의 경우, 좌하단이 끝
			sb.append(i - diff) // 차이만큼 감소
				.append("/")
				.append(1 + diff); // 차이만큼 증가
		}

		System.out.println(sb);
	}
}
