public class Solution {
	@Test
	public void aa() {
		int INF = 2147483647;
		int SIZE = 1000;
		int ARRAY_LENGTH = 100;

		int[][] sample = new int[SIZE][ARRAY_LENGTH];
		for (int count=0; count<SIZE; count++) {
			for (int i=0; i<ARRAY_LENGTH; i++) {
				sample[count][i] = new Random().nextInt(INF);
			}
		}

//		int[][] sample = {{10, 4}, {10, 3}, {6, 5}};
		int[] answer = solution(sample, SIZE);

		for (int i=0; i<answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

	public int[] solution(int[][] arr, int size) {
		Map<Integer, Integer> numMap = new HashMap<>();
		List<Integer> numList = new ArrayList<>();
		for (int i=0; i<arr.length; i++) {
			int num = 0;
			for (int j=0; j<arr[i].length; j++) {
				num += (1 << arr[i][j]);
			}
			numMap.put(num, i);
			numList.add(num);
		}

		numList.sort(Collections.reverseOrder());
		int[] result = new int[numList.size()];
		for (int i=0; i<numList.size(); i++) {
			result[i] = numMap.get(numList.get(i));
		}
		return result;
	}
}
