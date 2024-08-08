import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int[][] arr = new int[26][input.length() + 1];

        for (int i = 1; i <= input.length(); i++) {
            arr[input.charAt(i-1) - 'a'][i] = 1;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                arr[i][j] = arr[i][j - 1] + arr[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int c = st.nextToken().charAt(0) - 'a';

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(arr[c][end+1] - arr[c][start]).append("\n");
        }

        System.out.println(sb);
    }


}
