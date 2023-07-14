import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_10811 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());


            for (int j = 0; j < (e - s) / 2 + 1; j++) {
                int temp = arr[s + j];
                arr[s + j] = arr[e - j];
                arr[e - j] = temp;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
