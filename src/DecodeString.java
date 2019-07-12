import java.util.Stack;

class DecodeString {
	public static void main(String[] args) {
		System.out.print(decodeString("3[a]22[bc]"));
	}
	
    public static String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> bracks = new Stack<>();
        Stack<StringBuilder> words = new Stack<>();
        int num, prev=0, i=0;
        StringBuilder sb;
        StringBuilder sb1;
        StringBuilder word;
        StringBuilder ans = new StringBuilder();
        char c;
        boolean flag =  false;
        
        while(i<s.length()){
            c=s.charAt(i);
            if(isNum(c) && !flag) {
            	flag = true;
            	prev = i;
            }
            if(c=='['){
            	flag=false;
                String temp = s.substring(prev,i);
                nums.push(Integer.parseInt(temp));
                bracks.push('[');
                sb = new StringBuilder("");
                i++;
                while(s.charAt(i)!=']' && !isNum(s.charAt(i))){
                    sb.append(s.charAt(i));
                    i++;
                }
                words.push(sb);
                if(i<s.length() && isNum(s.charAt(i))){
                	prev = i;
                    continue;
                }else
                    c = s.charAt(i);
            }
            if(c==']'){
                num = nums.pop();
                word = words.pop();
                bracks.pop();
                sb1 = new StringBuilder();
                while(num>0){
                    sb1.append(word);
                    num--;
                }
                if(bracks.isEmpty())
                    ans.append(sb1);
                else
                    words.push(words.peek().append(sb1));
            }
            i++;
        }
        
        i = s.length()-1;
        while(s.charAt(i)!=']')
        	i--;
        i++;
        while(i<s.length()) {
        	ans.append(s.charAt(i));
        	i++;
        }
        return ans.toString();
    }
    
    public static boolean isNum(char c){
        return c>=48 && c<=57;
    }
}