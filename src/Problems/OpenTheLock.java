package Problems;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public static void main(String[] args) {
		String[] deadends = {"0201","0101","0102","1212","2002"};
		String target = "0202";
		System.out.print(openLock(deadends, target));
	}
	
    public static int openLock(String[] deadends, String target) {
        boolean valid = false;
        for(int i=0; i<4; i++){
            char n1 = (char)(target.charAt(i)+1);
            char n2 = (char)(target.charAt(i)-1);
            String ne1 = target.substring(0,i) + n1 + target.substring(i+1);
            String ne2 = target.substring(0,i) + n2 + target.substring(i+1);
            System.out.println(ne1 + " " + ne2);
            if(!Arrays.stream(deadends).anyMatch(ne1::equals) || !Arrays.stream(deadends).anyMatch(ne2::equals))
                valid = true;
        }
        if(!valid)
            return -1;
        
        String init = "0000";
        int dist = 0;
        Queue<String> q = new LinkedList<>();
        
        q.offer(init);
        while(!q.isEmpty()){
            String p = q.poll();
            if(p.equals(target)){
                return dist;
            }
            dist++;
            for(int i=0; i<4; i++){
                int n1 =  Character.digit(p.charAt(i), 3);
                String ne1 = p.substring(0,i) + (n1+1)%10 + p.substring(i+1);
                String ne2 = p.substring(0,i) + (n1+9)%10 + p.substring(i+1);
                System.out.println(ne1 + " " + ne2);
                if(!Arrays.stream(deadends).anyMatch(ne1::equals))
                    q.offer(ne1);
                if(!Arrays.stream(deadends).anyMatch(ne2::equals))
                    q.offer(ne2);
            }
        }
        return dist;
    }
}