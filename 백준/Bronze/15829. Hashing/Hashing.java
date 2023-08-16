import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());

        int r = 31;
        int m = 1234567891;

        int[] rMod = new int[51];
        rMod[0] = 1;

        for (int i = 1; i <= 50; i++) {
            rMod[i] = rMod[i - 1] * r % m;
        }

        String input = br.readLine();

        long sum = 0;
        for (int i = 0; i < input.length(); i++) {
            sum += (long) (input.charAt(i) - 'a' + 1) * rMod[i] % m;
        }
        System.out.println(sum);


    }
}

