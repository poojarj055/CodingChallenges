/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {
    if (nums.length === 0) return 0;

    let k = 1;

    for (let i = 1; i < nums.length; i++) {
        if (nums[i] !== nums[i - 1]) {
            nums[k] = nums[i];
            k++;
        }
    } return k;
};

```
Explanation
Initialization:

Start with k = 1 because the first element is always unique.
First Iteration (i = 1):

Compare the second element (nums[1]) with the first element (nums[0]).
Since they are equal, it indicates a duplicate.
Do not increment k.
Second Iteration (i = 2):

Compare the third element (nums[2]) with the second element (nums[1]).
Since they are not equal, it indicates a unique element.
Place this unique element at the position indicated by k.
Increment k.
End of Loop:

After processing all elements, k contains the number of unique elements.
The first k elements of nums are the unique elements in their original order.

```

