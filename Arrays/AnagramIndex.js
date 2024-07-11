/**
 * Function to find anagram mappings
 * @param {number[]} a - First array
 * @param {number[]} b - Second array
 * @returns {number[]} - Mapped indices
 */
function anagramMapping(a, b) {
    const indexMap = new Map();

    // Populate the indexMap with elements from b
    b.forEach((value, index) => {
        indexMap.set(value, index);
    });

    // Create the result array by mapping elements from a to their indices in b
    return a.map(value => indexMap.get(value));
}

// Example usage
const a = [12, 28, 46, 32];
const b = [46, 12, 32, 28];

const result = anagramMapping(a, b);
console.log(result); // Output: [1, 3, 0, 2]
