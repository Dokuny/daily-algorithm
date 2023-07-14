import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10809 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int[] arr = new int[26];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (arr[idx] == -1) {
                arr[idx] = i;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i])
                    .append(" ");
        }

        System.out.println(sb);
    }
}
