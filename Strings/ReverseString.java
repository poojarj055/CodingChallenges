//Reverse the given string in java

public String reverseString(String s) {
    char[] charArray = s.toCharArray();
    int left = 0, right = s.length() - 1;
    while (left < right) {
        char temp = charArray[left];
        charArray[left] = charArray[right];
        charArray[right] = temp;
        left++;
        right--;
    }
    return new String(charArray);
}
