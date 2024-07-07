// https://www.naukri.com/code360/problems/factorial-of-a-number_1115779?interviewProblemRedirection=true&search=factorial&leftPanelTabValue=SUBMISSION
// Write a program to find the factorial of a number.
// Factorial of n is:
// n! = n * (n-1) * (n-2) * (n-3)....* 1
// Output the factorial of 'n'. If it does not exist, output 'Error'.


function fact(n){
   
    /* Write your code here
    No need to specify return type 
    Input and output already taken care of, you have to just return the output variable */
 if (n == 0) {
        return 1;
    }
    if (n >= 1) {
        return n * fact(n - 1);
    }
     return "Error";
}
