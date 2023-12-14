import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	static final int P = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long[][] base = {{1, 0},{1, 0}};

		String input = br.readLine();

		BigInteger N = new BigInteger(input);

		if (N.compareTo(BigInteger.valueOf(2)) <= 0) {
			System.out.println(1);
			return;
		}

		long[][] matrix = {{1, 1}, {1, 0}};
		long[][] inverseMatrix = {{1, 0}, {0, 1}}; // 제곱 시, 역행렬이 필요함

		long[][] result = pow(matrix, inverseMatrix, N.subtract(BigInteger.valueOf(2)));

		long[][] longs = multipleMatrix(result, base);

		System.out.println(longs[0][0] % P);
	}

	// 행렬 제곱 메소드 (분할 정복)
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

	// 행렬 곱 메소드
	static long[][] multipleMatrix(long[][] a, long[][] b) {
		long[][] newArr = new long[2][2];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				long sum = 0;
				for (int k = 0; k < 2; k++) {
					sum += (a[i][k] * b[k][j]) % P;
				}
				newArr[i][j] = sum % P;
			}
		}
		return newArr;
	}

}

