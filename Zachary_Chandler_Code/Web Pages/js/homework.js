fib = function(n) {

    if (n == 0) {
        return 0;
    }

    var last1 = 0;
    var last2 = 1;

    for (var i = 0; i < n; i++) {
        let temp = last1 + last2;
        last1 = last2;
        last2 = temp;   
    }

    return last2;
}


bubbleSort = function(arr) {

    for (let i = 0; i < arr.length; i++) {
        for (let j = arr.length - 1; j >= i; j--) {
            if (arr[i] > arr[j]) {
                let temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
    }

    return arr;
}

reverseString = function(n) {
    let result = "";

    for (let i = 0; i < n.length; i++) {
        result = n[i] + result;
    }

    return result;
}

factorial = function(n) {

    let result = 1;

    for (let i = 2; i <= n; i++) {
        result *= i;
    }

    return result;
}

substring = function(n, i, j) {
    return n.substring(i, j);
}
