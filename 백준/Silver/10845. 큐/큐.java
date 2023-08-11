import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String operator = st.nextToken();

            switch (operator) {
                case "push":
                    queue.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        sb.append("-1");
                    } else {
                        sb.append(queue.pollFirst());
                    }
                    break;
                case "size":
                    sb.append(queue.size());
                    break;
                case "empty":
                    if (!queue.isEmpty()) {
                        sb.append("0");
                    } else {
                        sb.append("1");
                    }
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        sb.append("-1");
                    } else {
                        sb.append(queue.peekFirst());
                    }
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        sb.append("-1");
                    } else {
                        sb.append(queue.peekLast());

                    }
                    break;
            }
            if(!operator.equals("push")) sb.append("\n");
        }
        System.out.println(sb);

    }
}
