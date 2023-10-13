import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	static final int P = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		long[][] base = {{2, 0, 0}, {1, 0, 0}, {0, 0, 0}};

		long[][] matrix = {{2, 0, -1}, {1, 0, 0}, {0, 1, 0}};

		long a = fibo(new BigInteger(st.nextToken()).subtract(BigInteger.ONE), base, matrix);
		long b = fibo(new BigInteger(st.nextToken()), base, matrix);

		long answer = (b - a) % P;

		if (answer < 0) {
			answer += P;
		}
		System.out.println(answer % P);
	}

	static long fibo(BigInteger n, long[][] base, long[][] matrix) {
		if (n.compareTo(BigInteger.valueOf(2)) != 1) {
			return n.intValue();
		}

		long[][] pow = pow(matrix, n.subtract(BigInteger.valueOf(2)));

		return multipleMatrix(pow, base)[0][0];
	}

	static long[][] pow(long[][] matrix, BigInteger p) {
		if (p.compareTo(BigInteger.valueOf(2)) == -1) {
			return matrix;
		}
		long[][] result = null;

		while (p.compareTo(BigInteger.ZERO) == 1) {

			if (p.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)) {
				if (result == null) {
					result = matrix;
				} else {
					result = multipleMatrix(matrix, result);
				}
			}

			matrix = multipleMatrix(matrix, matrix);

			p = p.divide(BigInteger.valueOf(2));
		}

		return result;
	}

	static long[][] multipleMatrix(long[][] a, long[][] b) {
		long[][] newArr = new long[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				long sum = 0;
				for (int k = 0; k < 3; k++) {
					sum += (a[i][k] * b[k][j]) % P;
				}
				newArr[i][j] = sum % P;
			}
		}
		return newArr;
	}

}
