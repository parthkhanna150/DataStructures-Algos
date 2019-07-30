package Problems;
import java.util.LinkedList;
import java.util.Queue;

class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
          return;
        }
//this doesn't work. do a multidirectional bfs
        int nr = rooms.length;
        int nc = rooms[0].length;

        for (int r = 0; r < nr; r++) {
          for (int c = 0; c < nc; c++) {
            if (rooms[r][c] == 0) {
                
                int d = 0;
                Queue<Pair> q = new LinkedList<>();
                q.offer(new Pair(r,c));
                
                while(!q.isEmpty()){
                    
                    Pair parent = q.poll();
                    int i = parent.x;
                    int j = parent.y;
                    d++;
                    
                    if(i+1<nr && d<rooms[i+1][j]){
                        q.offer(new Pair(i+1,j));
                        rooms[i+1][j] = d;
                    }
                    if(i-1>=0 && d<rooms[i-1][j]){
                        q.offer(new Pair(i-1,j));
                        rooms[i-1][j] = d;
                    }
                    if(j+1<nc && d<rooms[i][j+1]){
                        q.offer(new Pair(i,j+1));
                        rooms[i][j+1] = d;
                    }
                    if(j-1>=0 && d<rooms[i][j-1]){
                        q.offer(new Pair(i,j-1));
                        rooms[i][j-1] = d;
                    }
                }
            }
            }
        }  
    }
}
                       
class Pair {
    int x, y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}