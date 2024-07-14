function addOneToNumber(arr) {
    // Remove leading zeros
    while (arr.length > 1 && arr[0] === 0) {
        arr.shift();
    }

    // Initialize an index (digit of units)
    let index = arr.length - 1;

    // Handle carry
    // This loop iterates from the last digit to the first digit. If a digit is 9,
    // it sets it to 0 and moves to the previous digit, simulating the carry-over effect of addition.
    while (index >= 0 && arr[index] === 9) {
        arr[index] = 0;
        index -= 1;
    }

    // If all digits were 9, the index becomes negative, indicating an overflow (e.g., 999 + 1 = 1000).
    // The first digit is set to 1, and an extra 0 is added at the end.
    if (index < 0) {
        // Insert a one at the beginning of the array
        arr[0] = 1;
        // Add one extra zero at the end of the array
        arr.push(0);
    } else {
        // Else increment the value at [index]
        arr[index] += 1;
    }

    return arr;
}

// Example usage:
const arr = [1, 2, 9];
console.log(addOneToNumber(arr)); // Output: [1, 3, 0]
