The problem you're describing is a variation of the well-known "Josephus Problem," which is a theoretical problem related to a certain elimination game. In this version of the problem, you are asked to find the order in which the questions are solved when the Ninja skips one question after solving one, moving in a circular manner.

### Explanation

Given `N` questions, Ninja starts at the first question and skips one question after solving one. This means he picks every second question in a circular manner until all questions are solved.

### Steps to Solve:
1. **Initialize a List**: Begin by initializing a list of questions from `1` to `N`.
2. **Simulate the Process**:
   - Start from the first question and remove it from the list.
   - Skip the next question and remove the following one.
   - Continue this process in a circular manner until all questions are removed.

### Example Walkthrough:
For `N = 5`, the questions are `[1, 2, 3, 4, 5]`.

1. Start at question `1`, skip `2`, and solve `3`. The current order is `[3]`.
2. Skip `4`, and solve `5`. The current order is `[3, 5]`.
3. Wrap around, skip `1`, and solve `2`. The current order is `[3, 5, 2]`.
4. Skip `4`, and solve `1`. The current order is `[3, 5, 2, 1]`.
5. Finally, solve `4`. The final order is `[3, 5, 2, 1, 4]`.

However, this can be done more systematically using a queue or a circular list structure.

### Java Implementation

```java
import java.util.*;

public class Solution {
    public static void findOrder(int N) {
        List<Integer> questions = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            questions.add(i);
        }
        
        List<Integer> order = new ArrayList<>();
        int index = 1; // Start at the second question (index 1 for 0-based indexing)
        
        while (!questions.isEmpty()) {
            order.add(questions.remove(index));
            if (!questions.isEmpty()) {
                index = (index + 1) % questions.size(); // Move to the next index, circularly
            }
        }
        
        // Print the order
        for (int i : order) {
            System.out.print(i + " ");
        }
    }
    
    public static void main(String[] args) {
        int N = 5;
        findOrder(N); // Example with N = 5, the output should be 2 4 1 5 3
    }
}
```

### Output:
For `N = 5`, the output will be:

```
2 4 1 5 3 
```

This method effectively simulates the process and returns the correct order in which the Ninja needs to solve the questions to clear the exam.
