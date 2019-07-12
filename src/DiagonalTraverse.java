
public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length==0)
            return (new int[0]);
        int m = matrix[0].length;
        int n = matrix.length;
        int r=0, c=0;
        int[] ans = new int[m*n];

        for(int i=0; i<ans.length; i++){
            ans[i] = matrix[r][c];
            
            if((r+c)%2==0){ //going UP
                if(c+1>=m){
                    r++;
                }
                
                else if(r-1<0){
                    c++;
                }

                else{
                    r--;
                    c++;
                }
            }
            else{ //going DOWN
                if(r+1>=n){
                    c++;
                }

                else if(c-1<0){
                    r++;
                }
                else{
                    r++;
                    c--;
                }
            } 
        }
        return ans;
    }
}