import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	static final int P = 998244353;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		long[][] base = {{1, 0, 0}, {1, 0, 0}, {0, 0, 0}};

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			BigInteger N = new BigInteger(br.readLine());

			long[][] matrix = {{0, 1, 1}, {1, 0, 0}, {0, 1, 0}};
			long[][] inverseMatrix = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

			long[][] result = pow(matrix, inverseMatrix, N.subtract(BigInteger.valueOf(2)));

			long[][] longs = multipleMatrix(result, base);

			sb.append(longs[0][0]).append("\n");
		}
		System.out.println(sb);
	}

	static long[][] pow(long[][] matrix, long[][] inverseMatrix, BigInteger p) {
		if (p.compareTo(BigInteger.valueOf(2)) == -1) {
			return matrix;
		}

		while (p.compareTo(BigInteger.ZERO) == 1) {

			if (p.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)) {
				inverseMatrix = multipleMatrix(matrix, inverseMatrix);
			}

			matrix = multipleMatrix(matrix, matrix);

			p = p.divide(BigInteger.valueOf(2));
		}

		return inverseMatrix;
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
