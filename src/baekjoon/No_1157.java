import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1157 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toLowerCase();

        int[] arr = new int[26];

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }

        int idx = 0;
        char answer = 'A';
        for (int i = 1; i < arr.length; i++) {
            if (arr[idx] < arr[i]) {
                idx = i;
                answer = (char)(idx +'A');
            } else if (arr[idx] == arr[i]) {
                answer = '?';
            }
        }

        System.out.println(answer);
    }
}
