import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10988 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
