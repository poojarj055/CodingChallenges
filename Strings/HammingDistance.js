// The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
// Given two integers x and y, return the Hamming distance between them.

// Input: x = 1, y = 4
// Output: 2
// Explanation:
// 1   (0 0 0 1)
// 4   (0 1 0 0)
//        ↑   ↑
// The above arrows point to positions where the corresponding bits are different.

/**
 * @param {number} x
 * @param {number} y
 * @return {number}
 */
var hammingDistance = function(x, y) {

// XOR the two numbers
// x = 0001
// y = 0100
// --------
// xor = 0101  (binary of XOR result)
    let xorResult = x ^ y;
    
    // Convert the result to binary string
    let binaryString = xorResult.toString(2);
    
    // Count the number of '1's in the binary string
    let count = 0;
    for (let char of binaryString) {
        if (char === '1') {
            count++;
        }
    }
    
    // Return the Hamming distance
    return count;
   
};
