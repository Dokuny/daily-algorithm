import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_5622 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);

            if (cur <= 'C') {
                sum += 2;
            } else if (cur <= 'F') {
                sum += 3;
            } else if (cur <= 'I') {
                sum += 4;
            } else if (cur <= 'L') {
                sum += 5;
            } else if (cur <= 'O') {
                sum += 6;
            } else if (cur <= 'S') {
                sum += 7;
            } else if (cur <= 'V') {
                sum += 8;
            } else if (cur <= 'Z') {
                sum += 9;
            }
        }
        System.out.println(sum + str.length());
    }
}
