import java.util.*;

class BracketMatch {
  
  static int bracketMatch(String text) {
    Stack<Character> stack = new Stack<>();
    HashMap<Character,Character> map = new HashMap<>();
    map.put('(',')');
    
    for(int i=0; i<text.length(); i++) {
    	char c = text.charAt(i);
    	
    	if(!stack.isEmpty() && c == map.getOrDefault(stack.peek(),'a')) {
    		stack.pop();
    	}
    	else {
    		stack.push(c);
    	}
    }
    return stack.size();
  }
  
  static int simpleBracketMatch(String text) {
	  int c=0, ans=0;
	  for(int i=0; i<text.length(); i++) {
		  char ch = text.charAt(i);
		  
		  if(ch=='(')
			  c++;
		  else if(ch==')')
			  c--;
		  if(c<0) {
			  c++;
			  ans++;
		  }
	  }
	  return c+ans;
  }

  public static void main(String[] args) {
    String b = ")(";
    System.out.println(simpleBracketMatch(b));
  }

}