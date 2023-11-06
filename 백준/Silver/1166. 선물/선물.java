import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;

public class Main {

	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		BigDecimal N = BigDecimal.valueOf(Long.parseLong(st.nextToken())); // 박스 개수
		BigDecimal L = BigDecimal.valueOf(Long.parseLong(st.nextToken()));
		BigDecimal W = BigDecimal.valueOf(Long.parseLong(st.nextToken()));
		BigDecimal H = BigDecimal.valueOf(Long.parseLong(st.nextToken()));

		// 이진탐색
		BigDecimal left = BigDecimal.ZERO;
		BigDecimal right = L.min(W.min(H));

		BigDecimal limit = BigDecimal.valueOf(Math.pow(10, -9));
		while (right.subtract(left).compareTo(limit) > 0) {
			BigDecimal mid = left.add(right).divide(BigDecimal.valueOf(2.0));

			long cnt = L.divide(mid,0, RoundingMode.FLOOR).longValue() *
				W.divide(mid,0, RoundingMode.FLOOR).longValue() *
				H.divide(mid,0, RoundingMode.FLOOR).longValue();

			if (cnt < N.longValue()) {
				right = mid;
			} else {
				left = mid;
			}
		}

		System.out.println(right);

	}

}