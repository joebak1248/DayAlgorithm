class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        List<List<Integer>> result = new ArrayList<>();
        bt(nums, 0, numList, result);
        return result;
    }
    
    private void bt(int[] nums, int first, List<Integer> numList, List<List<Integer>> out) {
        if (first >= numList.size() - 1) {
            out.add(new ArrayList<>(numList));
            return;
        }
        for (int i=first; i<nums.length; i++) {
            Collections.swap(numList, first, i);
            bt(nums, first + 1, numList, out);
            Collections.swap(numList, first, i);
        }
    }
}
