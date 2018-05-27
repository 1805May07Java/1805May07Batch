
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

function bubblesort(arr){
    var done = false;
    while(!done){
        done = true;
        for(var i = 1; i < arr.length; i++){
            if(arr[i -1] > arr[i]){
                done = false;
                var temp = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = temp;
            }
        }
    }
    return arr;
}

/*
3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
*/

function reverseStr(str) {
    var i = str.length;
    var rev = '';
    while (i--){
        rev += str[i];
    }
    return rev;
}
