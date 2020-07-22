import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 아래와 같이 이동 가능한 머신이 있다.
 *  - 걷기: 1 배터리 소모
 *  - 순간이동: 0 배터리 소모
 * 걷기는 단순이 이동경로를 1 이동한다. (ex: 1->2 배터리1소모, 1->2->3 배터리2소모)
 * 순간이동은 경로를 x2씩 이동하며 배터리소모를 하지 않는다. (ex: 1 > 2 (소모x), 2 > 4 (소모x)
 *
 * 목적지가 5일 때, 아래와 같은 경우의 수로 이동할 수 있다.
 *   0 1 2 3 4 5 (총 5번 이동)
 *   0 1 (2 > 4) 5 (총 3번 이동)
 *   0 1 (> 2 > 4) 5 (총 2번 이동)
 *
 *  목적지 n 까지 이동경로 중 가장 적은 배터리사용량을 출력하시오.
 */
public class Solution {
	@Test
	public void test() {
		Assert.assertEquals(2, solution(5));
		Assert.assertEquals(2, solution(6));
		Assert.assertEquals(5, solution(5000));
	}

	public int solution(int n) {
		// 2
		// 0(+2) 1(x2)
		//       0(+1)

		// 3
		// 0(+3) 1(x2 +1)    2(+1)
		//         0(+1)   0(+2) 1(x2)
		//                       0(+1)

		// 5
		// 4 3 2x2 1

		// 4
		// 3 (+1)
		// 1(x2 +1) 0(+3)
		// 0(+1)

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
