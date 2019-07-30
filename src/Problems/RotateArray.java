package Problems;
import java.util.Arrays;

class RotateArray {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		rotate(nums, 3);
	}
    public static void rotate(int[] nums, int k) {
        int p = 0;
        int n = nums.length;
        int[] temp = new int[n];
        for(int i=n-k; i<n; i++){
            temp[p++] = nums[i];
        }
        
        for(int i=0; i<n-k; i++){
            temp[p++] = nums[i];
        }
        nums = temp;
        System.out.print(Arrays.toString(nums));
    }
}