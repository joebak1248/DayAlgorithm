/**
 * 펙토리얼
 *
 * DP 가장 기본적인 알고리즘
 *
 * @author Joebak
 *
 */
public class Solution {

	@Test
	public void aa() {
		int answer = solution(30);
		System.out.print(answer);
		Assert.assertEquals(832040, answer);
	}

	int[] cache = new int[30];

	public int solution(int fibonacci) {
		if (fibonacci == 0) return 0;
		if (fibonacci == 1) return 1;

		if (cache[fibonacci-1] > 0) {
			return cache[fibonacci-1];
		}

		int answer = solution(fibonacci-1) + solution(fibonacci-2);
		cache[fibonacci-1] = answer;
		return answer;
	}

}
