// JavaScript program to find Product 
// of 2 Numbers using Recursion 

// recursive function to calculate 
// multiplication of two numbers 
function product(x, y) 
{ 
	// if x is less than 
	// y swap thenumbers 
	if (x < y) 
		return product(y, x); 

	// iteratively calculate 
	// y times sum of x 
	else if (y != 0) 
		return (x + product(x, y - 1)); 

	// if any of the two numbers is 
	// zero return zero 
	else
		return 0; 
} 

// Driver Code 
let x = 5; 
let y = 2; 
document.write(product(x, y)); 

// This code is contributed by mohan. 


