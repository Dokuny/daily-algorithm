import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] dirs = new int[][]{{-1, -1}, {1, 1}, {1, -1}, {-1, 1}};

    static boolean[][] map;
    static int N;
    static Node[] selected;
    static ArrayList<Node>[] nodes;
    static int result = -1;
    static int diagonalCnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new boolean[N][N];

        StringTokenizer st;

        diagonalCnt = N * 2 - 1;

        // 대각선에 놓여진 노드들의 리스트 배열 필요
        nodes = new ArrayList[diagonalCnt];
        for (int i = 0; i < diagonalCnt; i++) {
            nodes[i] = new ArrayList<>();
        }

        // 대각선별로 어떤 노드가 놓여져있는지 체크할 배열
        selected = new Node[diagonalCnt];

        int cnt = 0;
        // 노드 세팅
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0) == '1';

                if (map[i][j]) {
                    cnt++;
                }
            }
        }

        if (N == 1 && cnt == 1) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i < N; i++) {
            int x = i;
            int y = 0;

            if (map[y][x]) {
                nodes[i].add(new Node(x, y));
            }

            x -= 1;
            y += 1;

            while (x >= 0 && y >= 0 && x < N && y < N) {
                if (map[y][x]) {
                    nodes[i].add(new Node(x, y));
                }
                x -= 1;
                y += 1;
            }
        }

        int idx = N;
        for (int i = 1; i < N; i++) {
            int x = N - 1;
            int y = i;

            if (map[y][x]) {
                nodes[idx].add(new Node(x, y));
            }

            x -= 1;
            y += 1;

            while (x >= 0 && y >= 0 && x < N && y < N) {
                if (map[y][x]) {
                    nodes[idx].add(new Node(x, y));
                }
                x -= 1;
                y += 1;
            }
            idx++;

        }

        int sum = 0;
        dfs(0, 0);
        sum = result;
        result = -1;
        dfs(1, 0);

        System.out.println(sum + result);
    }

    // 놓을 수 있는 경우 놓는다 , 안놓는다 선택지
    // 홀수는 홀수 끼리, 짝수는 짝수 끼리

    public static void dfs(int lineNo, int cnt) {
        if (lineNo >= diagonalCnt) {
            result = Math.max(result, cnt);
            return;
        }

        // 대각선에서 노드를 안골랐을 때
        selected[lineNo] = null;
        dfs(lineNo + 2, cnt);

        // 대각선에서 노드를 골랐을 때
        for (int i = 0; i < nodes[lineNo].size(); i++) {
            // 현재 노드
            Node cur = nodes[lineNo].get(i);

            // 이전에 선택된 노드들과 비교
            boolean isPossible = true;
            for (int j = lineNo - 2; j >= 0; j -= 2) {
                if (selected[j] == null) continue;

                // 대각선에 놓여져 있다면
                if (Math.abs(selected[j].x - cur.x) == Math.abs(selected[j].y - cur.y)) {
                    isPossible = false;
                    break;
                }
            }
            // 대각선에 놓여져 있지 않다면
            if (isPossible) {
                selected[lineNo] = cur;
                dfs(lineNo + 2, cnt + 1);
                selected[lineNo] = null;
            }
        }

    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
