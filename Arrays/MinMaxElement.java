class Solution {
   public Pair<Long, Long> getMinMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        
        return new Pair<>((long) min, (long) max);
    }
}
