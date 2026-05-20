// Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
// Example 1:

// Input: nums = [1,1,2]
// Output:
// [[1,1,2],
//  [1,2,1],
//  [2,1,1]]
// Example 2:

// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

// Constraints:

// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
         List<List<Integer>> result=new ArrayList<>();
         boolean[] used = new boolean[nums.length]; 
         backtrack(result, new ArrayList<>(), nums, used);
         return result;
    }
    public void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int []nums, boolean[] used){
         if(tempList.size()==nums.length && !resultList.contains(tempList)){
            resultList.add(new ArrayList<>(tempList));
         }
         for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            tempList.add(nums[i]);
            used[i] = true;
            backtrack(resultList, tempList, nums, used);
            tempList.remove(tempList.size()-1);
            used[i] = false;
         }
    }
}
