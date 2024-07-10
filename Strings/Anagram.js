// 1st approach
// It then counts the frequency of each character in both strings.
// It compares the frequency of each character in the two strings.
// If all frequencies match, it returns true; otherwise, it returns false.
var isAnagram = function(s, t) {
    if(s.length !== t.length){
        return false;
    }

    const scount = {};
    const tcount = {};

    for(let i=0;i<s.length;i++){
        scount[s.charAt(i)] = scount[s.charAt(i)] + 1 || 1;
        tcount[t.charAt(i)] = tcount[t.charAt(i)] + 1 || 1;
    }

    for(const value of Object.keys(scount)){
        if(scount[value] !== tcount[value]){
            return false;
        }
    }
    return true;
    
};

//2nd Approach

/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */

var isAnagram = function(s, t) {
    if (s.length !== t.length) return false

    let chars = {}

    for (char of s) {
        chars[char] = chars[char]+1 || 1
    }

    for (char of t) {
        if (!chars[char]) {
            return false
        }
        chars[char]--
    }

    return true

};
