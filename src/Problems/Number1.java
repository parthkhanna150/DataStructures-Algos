package Problems;
import java.util.*;

class Number1{
    public static void main(String[] args) {
        int [] a  = {2,5,7,11};
        System.out.print(Arrays.toString(twoSum(a,9)));
    }

    public static int[] twoSum(int arr[], int target){
        HashMap<Integer, Integer> map  = new HashMap<>();
        int diff = 0;
        for(int i=0; i<arr.length; i++){
            diff = target  - arr[i];
            if(map.containsKey(arr[i])){
                return new int []{i, map.get(arr[i])};
            }
            else{
                map.put(diff, i);
            }
        }
        return new int[0];
    }
}