import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;

public class Main {

	static int P = 1000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BigInteger N = new BigInteger(br.readLine()).mod(BigInteger.valueOf(1500000L));

		int[] dp = new int[1500000];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i < dp.length; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % P;
		}


		System.out.println(dp[N.intValue()]);
	}
}
