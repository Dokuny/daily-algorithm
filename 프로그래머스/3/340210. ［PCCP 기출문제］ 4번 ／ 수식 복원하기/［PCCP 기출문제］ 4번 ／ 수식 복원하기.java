import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        
        List<Expression> list = new ArrayList<Expression>();
        
        int totalMax = 2;
        int answer = 0;
        
        // 수식 분리하기
        for(int i = 0; i < expressions.length; i++) {
            StringTokenizer st = new StringTokenizer(expressions[i]);
            
            int a = Integer.parseInt(st.nextToken());
            String command = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            st.nextToken();
            
            String result = st.nextToken();
            
            if(result.equals("X")) {
                list.add(new Expression(a,b,command));
                totalMax = Math.max(totalMax, Math.max(a/10, Math.max(a%10,Math.max(b/10, b%10))) + 1);
                continue;
            }
            
            int c = Integer.parseInt(result);
            
            // 진법 찾기
            // 먼저 두 수의 결과가 맞는지 확인 -> 맞다면 (가장 큰 숫자 + 1) ~ 9까지가 진법의 범위.
            int max = Math.max(a/10, Math.max(a%10,Math.max(b/10, Math.max(b%10,Math.max(c%10, Math.max(c/100, c%100/10))))));
            totalMax = Math.max(max + 1, totalMax);
            if(a + b == c || a - b == c){
               
            }else {
                if(answer == 0) {
                     // 결과가 다르다면 totalMax부터 진법 계산 시작
                    for(int j = totalMax; totalMax < 10; j++) {
                        int aTen = Integer.parseInt(String.valueOf(a), j);
                        int bTen = Integer.parseInt(String.valueOf(b), j);
                        int cTen = Integer.parseInt(String.valueOf(c), j);

                        if(cTen == (aTen + bTen) || cTen == (aTen - bTen)){ 
                            answer = j;
                            break;
                        }
                    }
                }
               
            }
        }
        
        
        String[] result = new String[list.size()];
        
        for(int i = 0; i < result.length; i++) {
            Expression exp = list.get(i);
            System.out.println(totalMax);
            if(answer != 0) {
                // answer 진법이므로 정답 계산
                // 기존 수를 10진법으로 계산 한 후, 다시 진법으로 변환
    
                int a = Integer.parseInt(String.valueOf(exp.a), answer);
                int b = Integer.parseInt(String.valueOf(exp.b), answer);
                
                int sum = 0;
                if(exp.command.equals("+")){
                    sum = a + b;
                }else {
                    sum = a - b;
                }
            
                result[i] = exp.a + " " + exp.command + " " + exp.b + " = " + Integer.toString(sum,answer);
            } else {
                // totalMax ~ 9 기준으로 정답 계산
                HashSet<String> set = new HashSet<String>();
                
                String last = "";
                
                for(int j = totalMax; j < 10; j++) {
                    
                    int a = Integer.parseInt(String.valueOf(exp.a), j);
                    int b = Integer.parseInt(String.valueOf(exp.b), j);
                    int sum = 0;
                    if(exp.command.equals("+")){
                        sum = a + b;
                    }else {
                        sum = a - b;
                    }
    
                    String temp = Integer.toString(sum, j);
                    set.add(temp);
                    last = temp;
                }
                
                if(set.size() != 1) {
                    result[i] = exp.a + " " + exp.command + " " + exp.b+ " = ?";
                } else {
                    result[i] = exp.a + " " + exp.command + " " + exp.b+ " = "+ last;
                }
            }
        }

        return result;
    }
    
    static class Expression {
        int a;
        int b;
        String command;
        
        Expression(int a, int b, String command) {
            this.a = a;
            this.b = b;
            this.command = command;
        }
    }
}