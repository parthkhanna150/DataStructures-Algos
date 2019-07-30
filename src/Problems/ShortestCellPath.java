package Problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestCellPath {
	public static void main(String[] args) {
		int mat[][] =
			{
				{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
				{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
				{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
			};

			// Find shortest path from source (0, 0) to
			// destination (7, 5)
		System.out.println(shortestValidCellPath(mat, 0, 0, 2, 5));
	}
	public static int shortestValidCellPath(int[][] grid, int sr, int sc, int dr, int dc) {
		if(grid == null || grid.length == 0)
			return -1;
		
		int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
		int count = 0;
		
		Queue<Coordinate> q = new LinkedList<>();
		
		q.offer(new Coordinate(sr, sc));
		
		while(!q.isEmpty()) {
			
			Queue<Coordinate> parents = q;
			q = new LinkedList<>();
			
			for(Coordinate pt: parents) {
				if(pt.r == dr && pt.c == dc)
					return count;
				for(int i=0; i<4; i++) {
					int nr = pt.r + directions[i][0];
					int nc = pt.c + directions[i][1];
					if(nr>=0 && nc>=0 && nr<grid.length && nc< grid[0].length && grid[nr][nc]==1) {
						q.offer(new Coordinate(nr, nc));
						grid[nr][nc] = 0;
					}
				}
			}
			count++;
		}
		return -1;
	}
}

class Coordinate{
	int r;
	int c;
	
	public Coordinate(int _r, int _c) {
		r = _r;
		c = _c;
	}
}
