
/*
1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/

function fib(n){
    var a = 0, b = 1, t;
    while (n-- > 0) {
    t = a;
    a = b;
    b += t;
    }
    return a;
}

/*
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/

