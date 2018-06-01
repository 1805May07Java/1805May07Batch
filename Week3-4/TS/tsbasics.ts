//TYPESCRIPT ENABLES STRICT TYPING
let welcome: string;
//welcome = 5; //5 is not assignable to type string
welcome = 'hello';

//let startsWithH = (<string>welcome).startsWith('h');
//let endsWithO =(welcome as string).endsWith('o');


/*
    TS DATA TYPES
*/

let a: number;
let b: boolean;
let c: string;
let d: object;
let arr: string[];
let tup =  [2, "test", {}]; //tuple - "heterogenous arrays"

let e: undefined;
//e = "testing"; //will not work

let f: null;
let g: any;
let h: never;

let add = function(a: number, b: number):number {
    //here we have strongly typed parameters and return types
    return a + b;
}

let printThings = function(note: string) {

}

// Another data type supported by TS is the Enum dafa type
// This is helpful if you find yourself working with a related set of constants such as days or colors, etc
enum Colors{
    RED = 0,
    GREEN = 1,
    BLUE = 2
};

let bgcolor = Colors.GREEN;

//array notation, again
let greet = function(welcome){
    console.log(`${welcome}!`);
}
// "This is a greeting " + welcome + "!"
let greet2 = (welcome) => console.log(`This is a greeting -- ${welcome}!`);
//in TS, we can accomplish the same thing with a shorter syntax using arrow notations
// this is a similar concept to lambdas in java, except we don't need FI

let doMore = (welcome, a, b) => {
    let num = a + b;
    console.log(`${welcome} ${num}`);
}



