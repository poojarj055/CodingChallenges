function sort(arr) {
  let c0 = 0, c1 = 0, c2 = 0;
  
  // Count occurrences of 0, 1, and 2
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] === 0) {
      c0++;
    } else if (arr[i] === 1) {
      c1++;
    } else if (arr[i] === 2) {
      c2++;
    }
  }

  // Reconstruct the array based on counts
  for (let i = 0; i < arr.length; i++) {
    if (c0 > 0) {
      arr[i] = 0;
      c0--;
    } else if (c1 > 0) {
      arr[i] = 1;
      c1--;
    } else if (c2 > 0) {
      arr[i] = 2;
      c2--;
    }
  }
}

process.stdin.resume();
process.stdin.setEncoding('utf8');

let input = '';
process.stdin.on('data', function (chunk) {
  input += chunk;
});

process.stdin.on('end', function () {
  const inputArray = input.trim().split('\n');
  const t = parseInt(inputArray[0], 10);
  
  let index = 1;
  for (let i = 0; i < t; i++) {
    const n = parseInt(inputArray[index], 10);
    const arr = inputArray[index + 1].trim().split(' ').map(Number);
    sort(arr);
    console.log(arr.join(' '));
    index += 2;
  }
});
