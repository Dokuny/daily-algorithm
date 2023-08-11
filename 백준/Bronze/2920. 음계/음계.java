import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int prev = Integer.parseInt(st.nextToken());
        if (prev != 1 && prev != 8) {
            System.out.println("mixed");
            return;
        }

        boolean isDescending = false;
        boolean isAscending = false;
        for (int i = 0; i < 7; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num < prev) {
                if (isAscending) {
                    System.out.println("mixed");
                    return;
                }
                isDescending = true;
            }

            if (num > prev) {
                if (isDescending) {
                    System.out.println("mixed");
                    return;
                }
                isAscending = true;
            }
            prev = num;
        }

        if (isDescending) {
            System.out.println("descending");
        } else {
            System.out.println("ascending");
        }
    }
}
