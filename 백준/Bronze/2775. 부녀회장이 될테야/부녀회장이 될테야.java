import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 아파트 구하기
        int[][] apt = new int[15][15];

        for (int j = 1; j < 15; j++) {
            apt[0][j] = j;
        }

        for (int i = 1; i <= 14; i++) {
            for (int j = 1; j <= 14; j++) {
                apt[i][j] = apt[i - 1][j] + apt[i][j-1];
            }
        }

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(apt[k][n]).append("\n");
        }
        System.out.println(sb);
    }


}

