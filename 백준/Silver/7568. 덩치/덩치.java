import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Person[] people = new Person[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            people[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1);
        }

        HashMap<Integer, ArrayList<Person>> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                // 나보다 큰 사람이 있는지 확인
                if (people[i].weight < people[j].weight && people[i].height < people[j].height) {
                    people[i].rank += 1;
                }
            }

            if (map.containsKey(people[i].rank)) {
                map.get(people[i].rank).add(people[i]);
            } else {
                ArrayList<Person> list = new ArrayList<>();
                list.add(people[i]);
                map.put(people[i].rank, list);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Person person : people) {
            sb.append(person.rank).append(" ");
        }

        System.out.println(sb);

    }

    static class Person {
        int weight;
        int height;
        int rank;

        public Person(int weight, int height, int rank) {
            this.weight = weight;
            this.height = height;
            this.rank = rank;
        }
    }


}

