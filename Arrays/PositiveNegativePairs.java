class Solution
{
    //Function to return list containing all the pairs having both
    //negative and positive values of a number in the array.
    public static ArrayList<Integer>findPairs(int arr[], int n) 
    { 
    	  HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int opposite = -num;

            if (set.contains(opposite)) {
                
                result.add(Math.min(num, opposite));
                result.add(Math.max(num, opposite));
            }

            
            set.add(num);
        }

        return result;
    }
}
