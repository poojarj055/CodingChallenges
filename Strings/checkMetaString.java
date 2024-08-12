Here's the Java implementation for the problem of determining whether two strings are meta strings:
Definition:
Meta Strings: Two strings are called meta strings if they can be made equal by swapping exactly one pair of distinct characters in one of the strings.
Note: If two strings are already equal, they are not considered meta strings.

### Java Code Implementation:

```java
import java.util.Scanner;

public class MetaStrings {
    
    public static boolean areMetaStrings(String str1, String str2) {
        // Check if lengths are different
        if (str1.length() != str2.length()) {
            return false;
        }

        // Find positions where characters differ
        int firstMismatch = -1, secondMismatch = -1;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (firstMismatch == -1) {
                    firstMismatch = i;
                } else if (secondMismatch == -1) {
                    secondMismatch = i;
                } else {
                    // More than two mismatches
                    return false;
                }
            }
        }

        // Exactly two mismatches needed
        if (secondMismatch != -1) {
            // Check if swapping makes the strings equal
            return (str1.charAt(firstMismatch) == str2.charAt(secondMismatch)) &&
                   (str1.charAt(secondMismatch) == str2.charAt(firstMismatch));
        }

        // If there are zero or one mismatches, they are not meta strings
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        
        for (int i = 0; i < T; i++) {
            String str1 = sc.nextLine().trim();
            String str2 = sc.nextLine().trim();
            if (areMetaStrings(str1, str2)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        
        sc.close();
    }
}
```

### Explanation:
- **Length Check**: The code first checks if the lengths of the two strings are the same. If they are not, it returns `false` because strings of different lengths cannot be meta strings.
- **Mismatch Finding**: The code iterates through both strings and finds the indices where the characters differ. It stores the first and second mismatched indices.
- **Condition Check**: If there are exactly two mismatches, it checks if swapping the mismatched characters in one string will make the strings equal. If this condition is satisfied, the strings are meta strings.
- **Output**: The program prints "Yes" if the strings are meta strings, and "No" otherwise.

### Example Input/Output:

```plaintext
Input:
2
Coding
Codnig
Ninjas
Niaxns

Output:
Yes
No
```

### Complexity:
- **Time Complexity**: \(O(n)\) where \(n\) is the length of the strings. The loop runs once for each string to find mismatches.
- **Space Complexity**: \(O(1)\) since no extra space is used except for a few variables to track mismatches.

This Java implementation efficiently determines whether the given pairs of strings are meta strings according to the defined conditions.
