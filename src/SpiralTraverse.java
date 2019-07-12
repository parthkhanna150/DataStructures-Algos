import java.util.ArrayList;
import java.util.List;

class SpiralTraverse {
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		ArrayList<Integer> ans = (ArrayList<Integer>) spiralOrder(matrix);
		for(int a: ans) {
			System.out.print(a+" ");
		}
	}
    public static List<Integer> spiralOrder(int[][] matrix) {
    	if(matrix==null)
    		return null;
    	int rows = matrix.length;
    	int cols = matrix[0].length;
        boolean[][] v  = new boolean[rows][cols];
        ArrayList<Integer> al = new ArrayList<>();
        int i=0, j=0;
        boolean up = false;
        return  spiral(matrix,  i, j, al, v, up);
    }
    
    public static List<Integer> spiral(int[][] m, int i, int j, ArrayList<Integer> al, boolean[][] v, boolean up) {
    	v[i][j]=true;
    	al.add(m[i][j]);
    	
    	if(i-1>=0  && v[i-1][j])
    		up=false;
    	
    	if(j+1<m[0].length && !v[i][j+1] && !up) {
    		return spiral(m,  i, j+1, al, v, up);
    	}
    	else if(i+1<m.length && !v[i+1][j] && !up) {
    		return spiral(m,  i+1, j, al, v, up);
    	}
    	else if(j-1>=0 && !v[i][j-1] && !up) {
    		return spiral(m,  i, j-1, al, v, up);
    	}
    	else if(i-1>=0 && !v[i-1][j]) {
    		return spiral(m,  i-1, j, al, v, true);
    	}

    	return al;
    }
    
    public static List<Integer> spiralIterative(int[][] m) {
    	return null;
    }

}