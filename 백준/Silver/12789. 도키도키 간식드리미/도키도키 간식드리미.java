import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        int order = 1;

        while (idx < n) {
            // 배열이 순서가 맞는 경우
            if(arr[idx] == order){
                idx++;
                order++;
            }else {
                // 배열 순서가 안맞는 경우

                // 스택을 확인
                // - 스택이 비어있으면 걍 집어넣기
                if (stack.isEmpty()) {
                    stack.addLast(arr[idx++]);
                } else {
                    // 스택이 안비어있으면
                    // 스택에 들어있는 애가 다음 숫자인지 확인
                    // - 다음 숫자라면
                    if (stack.peekLast() == order) {
                        stack.pollLast();
                        order++;
                    }else {
                        // 다음 숫자가 아니면
                        // 스택의 맨위보다 크면 성공할 수 없음
                        if (stack.peekLast() < arr[idx]) {
                            System.out.println("Sad");
                            return;
                        }else {
                            stack.addLast(arr[idx++]);
                        }
                    }

                }
            }
        }

        // stack에 값이 남아있는 경우
        while (!stack.isEmpty()) {
            if (stack.pollLast() != order) {
                System.out.println("Sad");
                return;
            }
            order++;
        }

        System.out.println("Nice");

    }


}
