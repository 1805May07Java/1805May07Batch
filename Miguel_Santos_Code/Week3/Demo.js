//Recorded on w3d2 @ 10:04


var a = 6;
var a;
console.log(a);  //prints 6 --if we redeclare, it will not lose its value

var interpolation = `our variable a still keeps its value of ${a}`;
var bool = "hello" == 5;


//functions pasted into console in browser
function fibb(n){
	if (n == 0) return 0;
	if (n == 1) return 1;
	return fibb(n-1) + fibb(n-2);
}

function reverseStr(str){
	var temp = [];
	var i;
	for(i=0; i<str.length; i++){
		temp += str[str.length - (i+1)];
	}
	return temp;
}

function bubbleSort(arr){
	var temp;
	var i, j;
	for(i=0; i<arr.length; ++i){
		for(j=0; j<arr.length-i; ++j){
			if(arr[j] > arr[j+1]){
				temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
			}
		}
	}
	return arr;
}