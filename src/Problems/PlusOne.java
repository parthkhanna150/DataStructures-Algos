package Problems;
import java.util.Arrays;

class PlusOne {
	public static void main(String[] args) {
		int[] ans = plusOne(new int[]{9,9,9});
		System.out.println(Arrays.toString(ans));
	}
    public static int[] plusOne(int[] digits) {
    	if(digits[digits.length-1]<=8) {
    		digits[digits.length-1]+=1;
    	}
    	else {
    		int i = digits.length-1;
    		while(i>=0 && digits[i]==9) {
    			digits[i]=0;
    			i--;
    		}
    		if(i==-1) {
    	    	int[] longer = new int[digits.length+1];
    			longer[0]=1;
    			return longer;
    		}
    		else {
    			digits[i]=digits[i]+1;
    		}
    	}
		return digits;
        
    }
}