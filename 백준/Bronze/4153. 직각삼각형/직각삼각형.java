import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) break;

            int powA = a * a;
            int powB = b * b;
            int powC = c * c;

            if (powA + powB == powC || powA + powC == powB || powB + powC == powA) {
                sb.append("right");
            } else {
                sb.append("wrong");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
