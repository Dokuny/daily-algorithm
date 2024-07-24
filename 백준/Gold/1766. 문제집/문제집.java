import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 문제 수
        int N = Integer.parseInt(st.nextToken());
        // 문제 정보 수
        int M = Integer.parseInt(st.nextToken());

        // 위상 정렬 이용
        // 대신 어떻게 쉬운 문제부터 풀게 만들 것 인가?
        // Union Find도 같이 넣기?

        ArrayList<Integer>[] adjList = new ArrayList[N + 1];


        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 걍 위상정렬 이용하고, 우선순위 큐를 UnionFind로 정렬시켜버리자
        int[] inDegree = new int[N + 1];
//        int[] parents = new int[N + 1];
//        for (int i = 1; i <= N; i++) {
//            parents[i] = i;
//        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int prev = Integer.parseInt(st.nextToken());
            int post = Integer.parseInt(st.nextToken());

            adjList[prev].add(post);
            inDegree[post]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()) {
            Integer no = pq.poll();

            sb.append(no).append(" ");
            for (Integer adjNo : adjList[no]) {
                inDegree[adjNo]--;

                if(inDegree[adjNo] == 0) {
                    pq.add(adjNo);
                }
            }
        }

        System.out.println(sb);

    }

//    static void union(int a, int b, int[] parents) {
//        int parentA = find(a, parents);
//        int parentB = find(b, parents);
//
//        if (parentA > parentB) {
//            parents[parentA] = parentB;
//        }else if(parentB > parentA){
//            parents[parentB] = parentA;
//        }
//
//    }
//
//    static int find(int a, int[] parents) {
//        if (parents[a] == a) {
//            return a;
//        }
//        return parents[a] = find(parents[a], parents);
//    }

}
