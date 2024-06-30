var twoSum = function(arr, target) {
    let pairs = [];
    if (arr.length < 2) {
        return [[-1, -1]]; // Return early for arrays with less than 2 elements
    }

    let map = new Map();
    // Populate the map with counts of each number in the array
    for (let num of arr) {
        if (map.has(num)) {
            map.set(num, map.get(num) + 1);
        } else {
            map.set(num, 1);
        }
    }

    // Iterate through the array to find pairs
    for (let num of arr) {
        let num2 = target - num;

        if (num === num2 && map.get(num) >= 2) {
            // Special case: num and num2 are the same and there are at least 2 occurrences
            pairs.push([num, num2]);
            map.set(num, map.get(num) - 2); // Decrement count for both occurrences
        } else if (num !== num2 && map.get(num) > 0 && map.get(num2) > 0) {
            // General case: num and num2 are different and both are present in the map
            pairs.push([num, num2]);
            map.set(num, map.get(num) - 1); // Decrement count for num
            map.set(num2, map.get(num2) - 1); // Decrement count for num2
        }
    }

    return pairs.length > 0 ? pairs : [[-1, -1]]; // Return pairs or default [-1, -1] if no pairs found
};

module.exports.solution = twoSum;
