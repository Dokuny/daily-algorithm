import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int[][] board = new int[5][5];


        HashSet<Integer>[] rows = new HashSet[5];
        HashSet<Integer>[] cols = new HashSet[5];
        HashSet<Integer>[] dias = new HashSet[2]; // 0 -> i==j , 1 -> i+j == 4

        for (int i = 0; i < 5; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }
        dias[0] = new HashSet<>();
        dias[1] = new HashSet<>();

        // 초기화 코드
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());

                rows[i].add(num);
                cols[j].add(num);

                if (i == j) dias[0].add(num);
                if (i + j == 4) dias[1].add(num);
            }
        }
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                cnt++;

                for (HashSet<Integer> row : rows) {
                    row.remove(num);
                }
                for (HashSet<Integer> col : cols) {
                    col.remove(num);
                }
                for (HashSet<Integer> dia : dias) {
                    dia.remove(num);
                }

                if (cnt >= 12) {
                    // 빙고 찾기
                    int bingoCnt = 0;
                    for (HashSet<Integer> row : rows) {
                        if (row.size() == 0) bingoCnt++;
                    }
                    for (HashSet<Integer> col : cols) {
                        if (col.size() == 0) bingoCnt++;
                    }
                    for (HashSet<Integer> dia : dias) {
                        if (dia.size() == 0) bingoCnt++;

                    }
                    if (bingoCnt >= 3) {
                        System.out.println(cnt);
                        return;
                    }
                }
            }
        }
    }
}

