import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] words = new String[3];
        words[0] = br.readLine();
        words[1] = br.readLine();
        words[2] = br.readLine();

        int max = 0;

        for (int i = 0; i < 3; i++) {
            if (words[i].equals("FizzBuzz") || words[i].equals("Fizz") || words[i].equals("Buzz")) {
            } else {
                max = Integer.parseInt(words[i]) + 3 - i;
                break;
            }
        }

        String answer = "";
        if(max % 3 == 0 && max % 5 == 0) {
            answer = "FizzBuzz";
        }else if(max % 3 == 0) {
            answer = "Fizz";
        } else if (max % 5 == 0) {
            answer = "Buzz";
        } else {
            answer = String.valueOf(max);
        }

        System.out.println(answer);
    }

}
