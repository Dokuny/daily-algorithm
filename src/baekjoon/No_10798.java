import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10798 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int maxLen = -1;

        String[] arr = new String[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine();
            if(maxLen < arr[i].length()) maxLen = arr[i].length();
        }

        char[][] arr2 = new char[5][maxLen];

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                arr2[i][j] = arr[i].charAt(j);
            }
        }

        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < 5; j++) {
                if(arr2[j][i] == '\0') continue;
                sb.append(arr2[j][i]);
            }
        }

        System.out.println(sb);
    }

}
