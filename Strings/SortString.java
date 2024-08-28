public class Solution {    
    public static String sortString(String s) {
        // Create an array to count the occurrences of each character
        int[] count = new int[26]; // Since there are 26 letters in the alphabet

        // Count each character in the string
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Build the sorted string using the count array
        StringBuilder sortedString = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                sortedString.append((char)(i + 'a'));
                count[i]--;
            }
        }

        return sortedString.toString();
    }

    public static void main(String[] args) {
        // Example usage
        String s = "helloworld";
        String sortedString = sortString(s);
        System.out.println(sortedString);  // Output: dehllloorw
    }
}
