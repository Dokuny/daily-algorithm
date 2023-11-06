import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] guitar = new int[M][2];

		int bundlePrice = Integer.MAX_VALUE;
		int piecePrice = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			bundlePrice = Math.min(bundlePrice, Integer.parseInt(st.nextToken()));
			piecePrice = Math.min(piecePrice, Integer.parseInt(st.nextToken()));
		}

		int bundle  = N / 6;
		int piece = N % 6;

		// 번들이 더 싼지
		int answer = Integer.MAX_VALUE;
		if (piece == 0) {
			answer = Math.min(bundle * bundlePrice, answer);
		}else{
			answer = Math.min((bundle+1) * bundlePrice, answer);
		}
		// 낱개가 더 싼지
		answer = Math.min(answer, N * piecePrice);
		// 섞는게 싼지

		if (piece * piecePrice > bundlePrice) {
			answer = Math.min((bundle+1) * bundlePrice , answer);
		} else {
			answer = Math.min(bundle * bundlePrice + piece * piecePrice, answer);
		}

		System.out.println(answer);


	}

}