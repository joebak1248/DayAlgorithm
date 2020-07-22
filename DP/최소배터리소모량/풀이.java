import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {
	@Test
	public void test() {
		Assert.assertEquals(2, solution(5));
		Assert.assertEquals(2, solution(6));
		Assert.assertEquals(5, solution(5000));
	}

	public int solution(int n) {
		return dfs(n);
	}
	Map<Integer, Integer> countMap = new HashMap<>();
	private int dfs(int goal) {
		if (countMap.containsKey(goal)) {
			return countMap.get(goal);
		}

		if (goal==1) {
			return 1;
		}

		List<Integer> moveList = new LinkedList<>();
		for (int i=0;i<goal; i++) {
			// 이동 (전부 배터리사용)
			if (i == 0) {
				moveList.add(goal);
				continue;
			}
			// 순간이동 (배터리사용x)
			if (i*2 == goal) {
				moveList.add(dfs(i));
				continue;
			}
			// 순간이동 + 이동 (배터리사용)
			int jump = i*2;
			if (jump < goal) {
				int moved = (goal - jump);
				moveList.add(moved + dfs(jump));
				continue;
			}

			// 이동 (배터리사용)
			int moved = (goal - i);
			moveList.add(moved + dfs(i));
		}

//		moveList.forEach(v -> System.out.print(v + " "));
//		System.out.println(" << " + goal);

		int min = moveList.stream().min(Comparator.comparing(Integer::valueOf)).get();
		countMap.put(goal, min);
		return min;
	}
}
