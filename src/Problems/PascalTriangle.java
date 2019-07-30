package Problems;
import java.util.ArrayList;
import java.util.List;
class PascalTriangle {
	public static void main(String[] args) {
		
		List<List<Integer>> list = generate(5);
		
		for(List<Integer> l: list) {
			for(int item: l) {
				System.out.print(item+",");
			}
			System.out.println();
		}
	}
	
    public static List<List<Integer>> generate(int numRows) {
        if(numRows<=0)
        	return (new ArrayList<List<Integer>>());
        
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> parent;
        List<Integer> init = new ArrayList<>();
        init.add(1);

    	outer.add(init);
        if(numRows==1) {
        	return outer;
        }
        
        init = new ArrayList<>();
        init.add(1);
        init.add(1);
        
        outer.add(init);
        if(numRows==2) {
        	return outer;
        }

        while(numRows-2>0) {
        	parent = init;
        	init = new ArrayList<>();
        	init.add(1);
        	for(int i=0; i<parent.size()-1; i++) {
        		init.add(parent.get(i)+parent.get(i+1));
        	}
        	init.add(1);
        	outer.add(init);
        	numRows--;
        }
        return outer;
	}
}