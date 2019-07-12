import java.util.*;

class ReverseWordsPramp {

  static char[] reverseWords(char[] arr) {
    mirrorReverse(arr, 0, arr.length-1);
    
    int wordStart = -1;
    int i=0;
    
    while(i<arr.length){
    	
    	if(arr[i]==' ') {
    		if(wordStart != -1) {
    			mirrorReverse(arr, wordStart, i-1);
    			wordStart = -1;
    		}
    	}
    	else if(i==arr.length-1) {
    		if(wordStart != -1) {
    			mirrorReverse(arr, wordStart, i);
    		}
    	}
    	else {
    		if(wordStart==-1) {
    			wordStart=i;
    		}
    	}
    	i++;
    }
    return arr;
  }

  private static void mirrorReverse(char[] arr, int i, int j) {
	int ss=i,ee=j; char tmp;
	while(ss<=ee) {
		tmp = arr[ss];
		arr[ss] = arr[ee];
		arr[ee] = tmp;
		ss++;
		ee--;
	}
  }
  
  public static void main(String[] args) {
	  char[] ex = {'a','a','c','e',' ',' ','e','e','w',' ',' ','j','d','d','t'};
	  char[] ans = reverseWords(ex);
	  System.out.println(Arrays.toString(ans));
  }
}