import org.junit.Assert;
import org.junit.Test;

/**
 * 아래와 같이 이동 가능한 머신이 있다.
 *  - 걷기: 1 배터리 소모
 *  - 순간이동: 0 배터리 소모
 * 걷기는 단순이 이동경로를 1 이동한다. (ex: 1->2 배터리1소모, 1->2->3 배터리2소모)
 * 순간이동은 경로를 x2씩 이동하며 배터리소모를 하지 않는다. (ex: 1 > 2 (소모x), 2 > 4 (소모x)
 *
 * 목적지가 5일 때, 아래와 같은 경우의 수로 이동할 수 있다.
 *   0 1 2 3 4 5 (배터리 사용량: 5)
 *   0 1 (2 > 4) 5 (배터리 사용량: 3)
 *   0 (1 > 2 > 4) 5 (배터리 사용량: 2)
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
		return 0;
	}
}
