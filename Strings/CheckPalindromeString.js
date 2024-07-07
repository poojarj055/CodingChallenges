/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    
    let i = 0;
    let j = s.length - 1;

    while (i < j) {
        while (i < j && !isLetterOrDigit(s[i])) {
            i++;
        }
        while (i < j && !isLetterOrDigit(s[j])) {
            j--;
        }
        if (i < j && s[i].toLowerCase() !== s[j].toLowerCase()) {
            return false;
        }
        i++;
        j--;
    }
    return true;
}

function isLetterOrDigit(c) {
    return /[a-zA-Z0-9]/.test(c);
    // The .test() method is called on the regular expression to test whether the string c contains any character that matches the pattern
    // defined by the regular expression.
}

