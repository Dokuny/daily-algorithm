import java.io.*;
import java.util.*;

public class Main {

    static int[][] dirs = {{-2, -1}, {-1, -2}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());


            Node start = null;
            Node destination = null;

            st = new StringTokenizer(br.readLine());
            start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine());
            destination = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);


            int[][] arr = new int[N][N];

            for (int i = 0; i < arr.length; i++) {
                Arrays.fill(arr[i], Integer.MAX_VALUE);
            }

            ArrayDeque<Node> queue = new ArrayDeque<>();

            queue.add(start);

            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                if(arr[cur.y][cur.x]!= Integer.MAX_VALUE) continue;

                arr[cur.y][cur.x] = cur.cnt;
                if (destination.x == cur.x && destination.y == cur.y) {
                    break;
                }
                for (int[] dir : dirs) {
                    int moveX = dir[0] + cur.x;
                    int moveY = dir[1] + cur.y;

                    if(moveX < 0 || moveY < 0 || moveX >= N || moveY >= N) continue;
                    if(arr[moveY][moveX] != Integer.MAX_VALUE) continue;

                    queue.add(new Node(moveX, moveY, cur.cnt + 1));
                }
            }

            System.out.println(arr[destination.y][destination.x]);

        }


    }


    static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }


}
