import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 중복값 제거
		StringTokenizer st;

		int[][] map = new int[4][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());

				map[j][i] = num;
			}
		}

		// A, B, C, D 배열의 합을 저장할 배열
		int[] sumAB = new int[N * N];
		int[] sumCD = new int[N * N];
		int indexAB = 0;
		int indexCD = 0;

		// A와 B의 합 저장
		for (int a : map[0]) {
			for (int b : map[1]) {
				sumAB[indexAB++] = a + b;
			}
		}

		// C와 D의 합 저장
		for (int c : map[2]) {
			for (int d : map[3]) {
				sumCD[indexCD++] = c + d;
			}
		}

		// 두 배열을 정렬
		Arrays.sort(sumAB);
		Arrays.sort(sumCD);

		long count = 0;

		// 투 포인터를 사용하여 중복된 합 처리
		int pointerAB = 0;
		int pointerCD = indexCD - 1;

		while (pointerAB < indexAB && pointerCD >= 0) {
			int currentSum = sumAB[pointerAB] + sumCD[pointerCD];

			if (currentSum == 0) {
				int countAB = 1;
				int countCD = 1;

				// 중복된 값 처리
				while (pointerAB + 1 < indexAB && sumAB[pointerAB] == sumAB[pointerAB + 1]) {
					pointerAB++;
					countAB++;
				}

				while (pointerCD - 1 >= 0 && sumCD[pointerCD] == sumCD[pointerCD - 1]) {
					pointerCD--;
					countCD++;
				}

				count += (long) countAB * countCD;
				pointerAB++;
				pointerCD--;
			} else if (currentSum < 0) {
				pointerAB++;
			} else {
				pointerCD--;
			}
		}


		System.out.println(count);
	}
}