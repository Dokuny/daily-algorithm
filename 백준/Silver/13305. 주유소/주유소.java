import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());


        int[] cost = new int[N - 1];

        for (int i = 0; i < cost.length; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int[] oilPrice = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            oilPrice[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int road = 0;
        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < N - 1; i++) {
            if(oilPrice[i] < minCost) {
                result += minCost * road;
                minCost = oilPrice[i];
                road = 0;
            }

            road += cost[i];
        }

        System.out.println(result + road * minCost);
    }


}
