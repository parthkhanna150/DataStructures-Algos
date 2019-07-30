package Problems;
import java.util.HashMap;
import java.util.HashSet;

public class Number3 {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("fabcafbavgdfa"));
	}

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;

        while(i<s.length() && j<s.length()){
        	char c = s.charAt(j);
            if (!set.contains(c)){
                set.add(c);
                j++;
                ans = Math.max(ans, j - i);
            }
            else {
            	char c2 = s.charAt(i);
                set.remove(c2);
                i++;
            }
        }
        return ans;
    }

    public static int lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        int j;
        int max = -1;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)) {
            	max = Math.max(max, count);
            	count = 0;
            	j = map.get(c);
            	map.clear();
                i = j;
            }
            else {
            	map.put(c, i);
            	count++;
            }
        }
        return Math.max(max, count);
    }
    
}
