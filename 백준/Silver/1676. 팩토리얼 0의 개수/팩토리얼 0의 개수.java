import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        int cnt = 0;
        while (true) {
            BigInteger mod = result.mod(BigInteger.TEN);

            if (mod.compareTo(BigInteger.ZERO) == 0) {
                cnt++;
            } else {
                break;
            }
            result = result.divide(BigInteger.TEN);
        }

        System.out.println(cnt);
    }
}

