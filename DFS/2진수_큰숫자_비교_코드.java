package com.nhnent.gia.poker.service;

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

/**
 * n자리의 2진수를 표시하는 배열이 있다.
 * 이 정수형 배열은 '1' 이 마킹되는 2진수자릿수를 나타낸다.
 *  ex> [5, 4, 1] = 11001
 *      [1, 2, 3] =   111
 *
 * 정수형 배열의 index 를 크기순으로 반환하는 함수를 완성하시오.
 *
 * 조건:
 *   n > 2147483648
 *   INPUT 배열 크기 < 1000
 *
 * INPUT: [[5, 4, 1], [1, 3, 4, 5], [1, 2, 3], [3, 4, 5, 6]]
 * OUTPUT: 3 1 0 2
 *
 * @author Joebak
 *
 */
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

//		int[][] sample = {{5, 4, 1}, {1 , 3, 4, 5}, {1,2,3}, {3,4,5,6}};
		int[] answer = solution(sample, SIZE);

//		for (int i=0; i<answer.length; i++) {
//			System.out.print(answer[i] + " ");
//		}
	}

	public int[] solution(int[][] arr, int size) {
		List<List<Integer>> allSortedList = new ArrayList<>();
		for (int[] value : arr) {
			List<Integer> queue = new LinkedList<>();
			queue.addAll(toList(value));
			allSortedList.add(queue);

//			queue.forEach(v -> System.out.print(v + " "));
//			System.out.println(" <<< VALUE ");
		}


		List<Integer> searchIndexList = new ArrayList<>();
		IntStream.range(0, arr.length).forEach(searchIndexList::add);
		List<Integer> visitedIndexList = new ArrayList<>();

		int[] answer = new int[size];
		int answerIndex = 0;

		while (searchIndexList.size() != visitedIndexList.size()) {
			int maxIndex = getMaxIndex(allSortedList, searchIndexList, 0, visitedIndexList);
			visitedIndexList.add(maxIndex);
			answer[answerIndex] = maxIndex;
			answerIndex++;
		}

		return answer;
	}

	private int getMaxIndex(List<List<Integer>> allSortedList, List<Integer> searchList, int compareIndex, List<Integer> visitedIndexList) {
		List<Integer> maxIndexList = new ArrayList<>();
		int maxValue = -1;
		for (int searchIndex : searchList) {
			if (visitedIndexList.contains(searchIndex)) {
				continue;
			}

			int value = allSortedList.get(searchIndex).get(compareIndex);
			if (value > maxValue) {
				maxIndexList.clear();
				maxIndexList.add(searchIndex);
				maxValue = value;
			} else if (value == maxValue) {
				maxIndexList.add(searchIndex);
			}
		}

		if (maxIndexList.size() > 1) {
			return getMaxIndex(allSortedList, maxIndexList, compareIndex+1, visitedIndexList);
		}

		return maxIndexList.get(0);
	}

	private List<Integer> toList(int[] arr) {
		List<Integer> list = new ArrayList<>();
		for (int val : arr) {
			list.add(val);
		}
		list.sort(Comparator.reverseOrder());
		return list;
	}
}
