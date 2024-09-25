import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Medal> medals = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            medals.add(new Medal(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        medals.sort((o1, o2) -> {
            if (o1.gold == o2.gold) {
                if (o1.silver == o2.silver) {
                    return o2.bronze - o1.bronze;
                } else {
                    return o2.silver - o1.silver;
                }
            } else {
                return o2.gold - o1.gold;
            }
        });

        int no = 1;
        if(medals.get(0).no != K) {
            for (int i = 1; i < N; i++) {
                Medal cur = medals.get(i);

                if (!cur.equals(medals.get(i - 1))) {
                    no = i + 1;
                }

                if (cur.no == K) {
                    break;
                }
            }
        }
        
        System.out.println(no);

    }

    static class Medal {
        int no;
        int gold;
        int silver;
        int bronze;

        public Medal(int no, int gold, int silver, int bronze) {
            this.no = no;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public boolean equals(Medal other) {
            return this.gold == other.gold && this.silver == other.silver && this.bronze == other.bronze;
        }
    }

}
