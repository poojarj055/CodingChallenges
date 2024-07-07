class Solution {
    public boolean isPalindrome(String s) {

        //Recursive approach
        // String s=str.replaceAll("[^A-Za-z0-9]", "").toUpperCase();

        // if(s.length()==0) return true;
        // if(s.length()==1) return true;
        // if(s.length()==2) {
        //     return s.charAt(0)==s.charAt(1)? true:false;
        // }
        // if (s.charAt(0) == s.charAt(s.length() - 1)) {
        // return isPalindrome(s.substring(1, s.length() - 1));
        // }
        // return false; 

        //2Poiner approach is optimized solution
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;

        }
        return true;
    }
}
