package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_19532 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());

		// 연립방정식을 이용해서 풀면 다음과 같이 풀 수 있음
		int x = (e * c - b * f) / (a * e - b * d);
		int y = (d * c - a * f) / (b * d - a * e);

		System.out.println(x + " " + y);

		// 아래는 단순한 브루트 포스로 푸는 법
//		for (int x = -999; x <= 999; x++) {
//			for (int y = -999; y <= 999; y++) {
//				if (a * x + b * y == c) {
//					if (d * x + e * y == f) {
//						System.out.println(x+" "+y);
//						break;
//					}
//				}
//			}
//		}
	}
}
