var reverseString = function(s) {
  //Recursive approach
    if(s=="")
    return"";
    else
    return reverseString(s.substr(1)) + s.charAt(0);

  //2 pointer approach
    // let left = 0, right = s.length- 1;
    // while (left < right) {
    //     let temp = s[left];
    //     s[left] = s[right];
    //     s[right] = temp;
    //     left++;
    //     right--;
    // }
    // return s;
};

