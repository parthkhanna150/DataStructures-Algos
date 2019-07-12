import java.util.Arrays;

public class FloodFill {
	
	public static void main(String[] args) {
		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr = 1, sc = 1, newColor = 2;
		int[][] flooded = floodFill(image, sr, sc, newColor);
		for(int[] flood: flooded) {
			System.out.println(Arrays.asList(flood));
		}
	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int oldColor =  image[sr][sc];
		floodFill(image, oldColor, newColor, sr+1, sc);
		floodFill(image, oldColor, newColor, sr-1, sc);
		floodFill(image, oldColor, newColor, sr, sc+1);
		floodFill(image, oldColor, newColor, sr, sc-1);
		return image;
	}
	
	public static void floodFill(int[][] image, int oldColor, int newColor, int r, int c) {
		if(r<0||c<0||r==image.length||c==image[0].length||image[r][c]==oldColor)
			return;
		image[r][c] = oldColor;
		floodFill(image, oldColor, newColor, r+1, c);
		floodFill(image, oldColor, newColor, r-1, c);
		floodFill(image, oldColor, newColor, r, c+1);
		floodFill(image, oldColor, newColor, r, c-1);
	}
}
