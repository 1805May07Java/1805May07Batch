

foo = function() {
    let n = fib(document.getElementById("fibIndex").value);

    document.getElementById("fibValue").innerHTML = n;
}

facSubmit = function() {
    let n = factorial(document.getElementById("facIndex").value);
    document.getElementById("facValue").innerHTML = n;
}

submitReverseString = function() {
    let n = reverseString(document.getElementById("string-to-reverse").value);
    document.getElementById("string-to-reverse").value = n;
}
