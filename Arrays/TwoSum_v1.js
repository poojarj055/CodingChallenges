var twoSum = function(arr, target, n) {
    // Write your code here.
    let pair = new Set();
    
    for (let i = 0; i < n - 1; i++) {
        for (let j = i+1 ; j < n; j++) {
            if (arr[i] + arr[j] === target ) {
                pair.add([arr[i], arr[j]]);
                arr[i] = Number.POSITIVE_INFINITY;
                arr[j] = Number.POSITIVE_INFINITY;
                break;
            }
        }
    }
    // console.log("Set is empty", pair);
    if (pair.size === 0) {
        pair.add([-1, -1]);

    }
    
    return pair;

};

module.exports.solution = twoSum;
