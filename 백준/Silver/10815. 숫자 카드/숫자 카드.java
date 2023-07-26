import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 23.07.26
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashSet<Integer> set = new HashSet<Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            if (set.contains(Integer.parseInt(st.nextToken()))) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }


}