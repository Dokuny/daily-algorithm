class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        String prev = "prev";
        String next = "next";
        
        // 문자열 시간을 숫자 시간으로 변환 필요
        int totalTime = Integer.parseInt(video_len.substring(0,2)) * 60 + Integer.parseInt(video_len.substring(3,5));
        int curTime = Integer.parseInt(pos.substring(0,2)) * 60 + Integer.parseInt(pos.substring(3,5));
        
        int opTime = Integer.parseInt(op_start.substring(0,2)) * 60 + Integer.parseInt(op_start.substring(3,5));
        int endTime = Integer.parseInt(op_end.substring(0,2)) * 60 + Integer.parseInt(op_end.substring(3,5));
        if(opTime <= curTime && curTime <= endTime) curTime = endTime;
        
        for(String command : commands) {
            if(command.equals(prev)){
                curTime = curTime < 10 ? 0 : curTime - 10;
            }else if(command.equals(next)){
                curTime = (totalTime - curTime) < 10 ? totalTime : curTime + 10;
            }
            
            if(opTime <= curTime && curTime <= endTime) curTime = endTime;
        }
        
        new StringBuilder();
        
        return   (curTime / 60 >= 10 ? curTime/60 : "0"+curTime/60) + ":" + (curTime % 60 >= 10 ? curTime % 60 : "0" + curTime % 60);
    }
    
}