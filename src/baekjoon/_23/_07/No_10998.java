package baekjoon._23._07;

import java.util.Scanner;

/**
 *  번호 - 10998
 *  제목 - AxB
 *  문제 - 두 정수 A와 B를 입력받은 다음, AxB를 출력하는 프로그램을 작성하시오.
 *  입력 - 첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)
 *  출력 - 첫째 줄에 AxB를 출력한다.
 */
public class No_10998 {

	public static void main(String[] args) {
		// 기본적인 입력 방법
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();

		System.out.println(A * B);

		// BufferedReader 사용 - 더 빠른 방법
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine()); // split보다는 StringTokenizer가 성능상 이득, 하지만 여기선 크기가 작기 때문에 별 차이는 없음
//		int A = Integer.parseInt(st.nextToken());
//		int B = Integer.parseInt(st.nextToken());
//
//		System.out.println(A * B);
	}

}
