// Given an array of strings words and an integer k, return the k most frequent strings.\
// Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
// Example 1:

// Input: words = ["i","love","leetcode","i","love","coding"], k = 2
// Output: ["i","love"]
// Explanation: "i" and "love" are the two most frequent words.
// Note that "i" comes before "love" due to a lower alphabetical order.
// Example 2:

// Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
// Output: ["the","is","sunny","day"]
// Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 

// Constraints:

// 1 <= words.length <= 500
// 1 <= words[i].length <= 10
// words[i] consists of lowercase English letters.
// k is in the range [1, The number of unique words[i]]
// Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?


class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map=new HashMap<>();
        for(String word: words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        PriorityQueue<String> heap=new PriorityQueue<>((a, b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);
            if (freqA != freqB) {
                return freqA - freqB; // Min-heap by frequency
            }
            return b.compareTo(a); // Max-heap by word (reverse alphabetical for ties)
        });
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            heap.offer(entry.getKey());

            if(heap.size()>k){
                heap.poll();
            }
        }
        ArrayList<String> result=new ArrayList<>();
        for(int i=0;i<k;i++){
            result.add(heap.poll());
        }
        Collections.reverse(result);
        
        return result;
    }
}
