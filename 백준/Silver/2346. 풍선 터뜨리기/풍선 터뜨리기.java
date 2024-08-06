import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Balloon> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            deque.addLast(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty()) {
            Balloon cur = deque.pollFirst();

            sb.append(cur.num).append(" ");

            if (!deque.isEmpty()) {
                if (cur.move < 0) {
                    for (int i = 0; i < Math.abs(cur.move); i++) {
                        deque.addFirst(deque.pollLast());
                    }
                } else {
                    for (int i = 0; i < Math.abs(cur.move) - 1; i++) {
                        deque.addLast(deque.pollFirst());
                    }
                }
            }
        }

        System.out.println(sb);


    }

    static class Balloon {
        int num;
        int move;

        public Balloon(int num, int move) {
            this.num = num;
            this.move = move;
        }
    }


}
