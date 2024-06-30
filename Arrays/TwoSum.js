var twoSum = function (arr, target, n) {

    let pairs = [];
    if (arr.length <= 1) {
        pairs.push([-1, -1]);
        return pairs;
    }


    let map = new Map();
    for (let i = 0; i < arr.length; i++) {
        if (map.has(arr[i])) {
            map.set(arr[i], map.get(arr[i])+1)
        } else {
            map.set(arr[i], 1);
        }
    }


    for (let i = 0; i < arr.length; i++) {
        let num = arr[i];
        let num2 = target - num;

        if (map.has(num2)) {
            if (map.get(num)) {
                map.set(num, map.get(num) - 1);
            } else {
                break;
            }

            if (map.get(num2)) {
                map.set(num2, map.get(num2) - 1);
            } else {
                break;
            }

            pairs.push([num2, num]);
        }
    }

    if (pairs.length === 0) {
        pairs.push([-1, -1]);
    }
    
    return pairs;

};

module.exports.solution = twoSum;
