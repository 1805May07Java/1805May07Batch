//TYPESCRIPT ENABLES STRICT TYPING
var welcome;
//welcome = 5; //5 is not assignable to type string
welcome = 'hello';
//let startsWithH = (<string>welcome).startsWith('h');
//let endsWithO =(welcome as string).endsWith('o');
/*
    TS DATA TYPES
*/
var a;
var b;
var c;
var d;
var arr;
var tup = [2, "test", {}]; //tuple - "heterogenous arrays"
var e;
//e = "testing"; //will not work
var f;
var g;
var h;
var add = function (a, b) {
    //here we have strongly typed parameters and return types
    return a + b;
};
var printThings = function (note) {
};
// Another data type supported by TS is the Enum dafa type
// This is helpful if you find yourself working with a related set of constants such as days or colors, etc
var Colors;
(function (Colors) {
    Colors[Colors["RED"] = 0] = "RED";
    Colors[Colors["GREEN"] = 1] = "GREEN";
    Colors[Colors["BLUE"] = 2] = "BLUE";
})(Colors || (Colors = {}));
;
var bgcolor = Colors.GREEN;
//array notation, again
var greet = function (welcome) {
    console.log(welcome + "!");
};
// "This is a greeting " + welcome + "!"
var greet2 = function (welcome) { return console.log("This is a greeting -- " + welcome + "!"); };
//in TS, we can accomplish the same thing with a shorter syntax using arrow notations
// this is a similar concept to lambdas in java, except we don't need FI
var doMore = function (welcome, a, b) {
    var num = a + b;
    console.log(welcome + " " + num);
};
