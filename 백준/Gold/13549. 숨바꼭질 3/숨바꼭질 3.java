import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[100001];

        ArrayDeque<Node> queue = new ArrayDeque<>();

        Arrays.fill(arr, Integer.MAX_VALUE);

        queue.add(new Node(N, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if(arr[cur.x] <= cur.time) continue;

            arr[cur.x] = cur.time;

            if (cur.x - 1 >= 0) {
                queue.add(new Node(cur.x - 1, cur.time + 1));
            }

            if (cur.x + 1 < arr.length) {
                queue.add(new Node(cur.x + 1, cur.time + 1));
            }

            if (cur.x * 2 < arr.length) {
                queue.add(new Node(cur.x * 2, cur.time));
            }
        }

        System.out.println(arr[K]);
    }

    static class Node{
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
