// Problem statement
// You are given a string 'S'. Your task is to check whether the string is palindrome or not. For checking palindrome, consider alphabets and numbers only and ignore the symbols and whitespaces.
// Note :
// String 'S' is NOT case sensitive.
// Example :
// Let S = “c1 O$d@eeD o1c”.
// If we ignore the special characters, whitespaces and convert all uppercase letters to lowercase, we get S = “c1odeedo1c”, which is a palindrome. Hence, the given string is also a palindrome.


function checkPalindrome(stringvalue) {
    var str = stringvalue.replace(/[^A-Z0-9]+/ig, "").toUpperCase();
    
    // Base cases for palindrome check
    if (str.length === 0) {
        return "Yes"; // An empty string is considered a palindrome
    }
    if (str.length === 1) {
        return "Yes"; // Single character string is a palindrome
    }
    if (str.length === 2) {
        return str[0] === str[1] ? "Yes" : "No"; // Two characters should match to be a palindrome
    }
    
    // Recursive check for palindrome
    if (str[0] === str.slice(-1)) {
        return checkPalindrome(str.slice(1, -1));
    }
    
    return "No";
}

function main() {
    // Read the number of test cases
    let testcase = parseInt(readLine().trim());

    // Loop through each test case
    while (testcase > 0) {
        // Read the input string for each test case
        let str = String(readLine());

        // Call your function with the input
        let result = checkPalindrome(str);

        // Output the result
        console.log(result);
        
        // Decrement the testcase counter
        testcase--;
    }
}
