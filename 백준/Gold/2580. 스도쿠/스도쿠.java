import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] sudoku = new int[9][9];

    static Set<Integer>[] rows = new HashSet[9];
    static Set<Integer>[] cols = new HashSet[9];
    static Set<Integer>[] boxes = new HashSet[9];
    static Deque<int[]> deque;

    static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                rows[i] = new HashSet<>();
                cols[i] = new HashSet<>();
                boxes[i] = new HashSet<>();
            }
        }

        deque = new ArrayDeque<>();
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());

                sudoku[i][j] = num;

                if (num == 0) {
                    deque.add(new int[]{j, i});
                    continue;
                }

                rows[i].add(num);
                cols[j].add(num);
                boxes[(i / 3) * 3 + j / 3].add(num);
            }
        }
        sb = new StringBuilder();

        // 해결 코드
        dfs();

        System.out.println(sb);

        // 출력 코드

    }

    private static void dfs() {
        if(sb.length() != 0) return;

        // 성공 조건
        // 0를 넣었던 deque이 비면 성공
        if (deque.isEmpty()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]).append(" ");
                }
                sb.append("\n");
            }
            return;
        }

        // 빈칸 꺼내오기
        int[] empty = deque.pollFirst();

        // 각 set별 인덱스 계산
        int row = empty[1];
        int col = empty[0];
        int box = (row / 3) * 3 + col / 3;

        // 빈칸에 들어갈 수 있는 수 찾기
        for (int i = 1; i <= 9; i++) {
            if(sb.length() != 0) return;
            if(rows[row].contains(i)) continue;
            if(cols[col].contains(i)) continue;
            if(boxes[box].contains(i)) continue;

            rows[row].add(i);
            cols[col].add(i);
            boxes[box].add(i);

            sudoku[row][col] = i;
            dfs();
            sudoku[row][col] = 0;

            rows[row].remove(i);
            cols[col].remove(i);
            boxes[box].remove(i);
        }

        deque.addFirst(empty);

    }


}
