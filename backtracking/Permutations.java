// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
// Example 1:

// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2:

// Input: nums = [0,1]
// Output: [[0,1],[1,0]]
// Example 3:

// Input: nums = [1]
// Output: [[1]]

class Solution {
    public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> result=new ArrayList<>();
         backtrack(result, new ArrayList<>(), nums);
         return result;
    }
    public void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int []nums){
         if(tempList.size()==nums.length){
            resultList.add(new ArrayList<>(tempList));
         }
         for(int i=0;i<nums.length;i++){
            if(tempList.contains(nums[i])){
                continue;
            }
            tempList.add(nums[i]);
            backtrack(resultList, tempList, nums);
            tempList.remove(tempList.size()-1);
         }
    }
}
