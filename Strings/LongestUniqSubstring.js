```

Problem statement
Given a string input of length n, find the length of the longest substring without repeating characters i.e return a substring that does not have any repeating characters.
Substring is the continuous sub-part of the string formed by removing zero or more characters from both ends.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
 1<= n <=10^5

Time Limit: 1 sec
Sample Input 1:
 abcabcbb 
Sample Output1:
 3

```


function lengthOfLongestSubstring(s) {
    let n = s.length;
    let set = new Set();
    let maxLength = 0;
    let left = 0;

    for (let right = 0; right < n; right++) {
        // If the character at the 'right' pointer is in the set, 
        // remove characters from the 'left' until it is removed from the set
        while (set.has(s[right])) {
            set.delete(s[left]);
            left++;
        }

        // Add the current character to the set
        set.add(s[right]);

        // Update the maximum length found
        maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
}

function main() {

    /* Read your input here 
    eg: For string variables:   let str = String(readLine()); 
        For int variables: let var_name = parseInt(readLine());
        For arrays : const arr = readLine().replace(/\s+$/g, '').split(' ');
    */
    let str = String(readLine()); 
    console.log(lengthOfLongestSubstring(str));
    /*
    Call your function with the input/parameters read above
    eg: let x = example(var_name, arr);
    */

   /*
   Log your output here 
   eg: console.log(x);
   */

}


Dry Run with Example abcabcbb
Initialization:

s = "abcabcbb"
n = 8
set = {}
maxLength = 0
left = 0
Step-by-step Execution:

Iteration 1 (right = 0):

s[right] = 'a'
set does not contain 'a'
Add 'a' to set: set = {'a'}
Update maxLength: maxLength = max(0, 0 - 0 + 1) = 1


Iteration 2 (right = 1):

s[right] = 'b'
set does not contain 'b'
Add 'b' to set: set = {'a', 'b'}
Update maxLength: maxLength = max(1, 1 - 0 + 1) = 2


Iteration 3 (right = 2):

s[right] = 'c'
set does not contain 'c'
Add 'c' to set: set = {'a', 'b', 'c'}
Update maxLength: maxLength = max(2, 2 - 0 + 1) = 3


Iteration 4 (right = 3):

s[right] = 'a'
set contains 'a'
Remove 'a' from set by moving left to 1: set = {'b', 'c'}, left = 1
Add 'a' to set: set = {'b', 'c', 'a'}
Update maxLength: maxLength = max(3, 3 - 1 + 1) = 3


Iteration 5 (right = 4):

s[right] = 'b'
set contains 'b'
Remove 'b' from set by moving left to 2: set = {'c', 'a'}, left = 2
Add 'b' to set: set = {'c', 'a', 'b'}
Update maxLength: maxLength = max(3, 4 - 2 + 1) = 3


Iteration 6 (right = 5):

s[right] = 'c'
set contains 'c'
Remove 'c' from set by moving left to 3: set = {'a', 'b'}, left = 3
Add 'c' to set: set = {'a', 'b', 'c'}
Update maxLength: maxLength = max(3, 5 - 3 + 1) = 3


Iteration 7 (right = 6):

s[right] = 'b'
set contains 'b'
Remove 'b' from set by moving left to 4: set = {'a', 'c'}, left = 4
Add 'b' to set: set = {'a', 'c', 'b'}
Update maxLength: maxLength = max(3, 6 - 4 + 1) = 3


Iteration 8 (right = 7):

s[right] = 'b'
set contains 'b'
Remove 'b' from set by moving left to 5: set = {'a', 'c'}, left = 5
Add 'b' to set: set = {'a', 'c', 'b'}
Update maxLength: maxLength = max(3, 7 - 5 + 1) = 3
