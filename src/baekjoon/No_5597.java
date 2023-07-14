import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_5597 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] arr = new boolean[31];

        for (int i = 0; i < 28; i++) {
            arr[Integer.parseInt(br.readLine())] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            if(!arr[i]) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}
