package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2869 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

/**
 *      while문으로 하나하나 돌리면 시간초과 발생 (10억 이상의 연산이 발생할 수도)
 *      int cur = 0;
 * 		int day = 0;
 *
 * 		while (true) {
 * 			cur += A;
 * 			day++;
 * 			if (cur >= V) {
 * 				break;
 *                        }
 * 			cur -= B;* 		}
 * 		System.out.println(day);
 */
		// 하루에 올라갈 수 있는 높이
		int one = A - B;
		// 마지막 날에 밤까지 가지 않고 낮에 등반하는 경우가 발생하므로 전체 높이에서 낮에 올라가는 높이 제외
		int remain = V - A;
		// 남은 높이 / 하루 높이 -> 등반하는데 걸리는 날짜 + 마지막 날 낮 등반한 것 하루
		int day = remain / one + 1;
		// 딱 떨어지지 않으면 하루 더 올라가야 하므로 1 추가
		if (remain % one != 0) {
			day++;
		}
		System.out.println(day);
	}

}
