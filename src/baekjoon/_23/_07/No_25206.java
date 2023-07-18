package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class No_25206 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        HashMap<String, Double> map = new HashMap<>();

        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);


        StringTokenizer st;
        double creditSum = 0.0;
        double gradeSum = 0.0;

        String str = "";
        while ((str = br.readLine()) != null) {
            if (str == null) break;

            st = new StringTokenizer(str);

            st.nextToken();

            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (grade.equals("P")) continue;

            creditSum += credit;
            gradeSum += credit * map.get(grade);
        }

        System.out.println(gradeSum / creditSum);
    }
}
