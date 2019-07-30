package Problems;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class DailyTemperatures {
	public static void main(String[] args) {
		int[] T = {73,74,75,71,69,72,76,73};
		int[] ans = dailyTemperatures(T);
		System.out.print(Arrays.toString(ans));
	}

	public static int[] dailyTemperatures(int[] T) {
		HashMap<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		int[] ans = new int[T.length];
		for (int i = 0; i < T.length; i++) {
			map.put(i, T[i]);
		}

		for (int i = 0; i < T.length; i++) {
			if (stack.isEmpty() || map.get(stack.peek()) >= T[i]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty() && map.get(stack.peek()) < T[i]) {
					ans[stack.peek()] = i - stack.peek();
					stack.pop();
				}
				stack.push(i);
			}
		}
		while (!stack.isEmpty()) {
			ans[stack.pop()] = 0;
		}
		return ans;
	}

}
