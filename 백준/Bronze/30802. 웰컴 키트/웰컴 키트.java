import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[6];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int shirt = 0;

        for (int n : arr) {
            shirt += n / T;

            if (n % T != 0) {
                shirt++;
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(shirt).append("\n")
                .append(N / P).append(" ").append(N % P);

        System.out.println(sb);
        
    }

}
