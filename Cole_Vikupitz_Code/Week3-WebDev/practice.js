// practice.js
// Author: Cole Vikupitz
//
// A variety of JS functions for practice from:
// http://exercism.io/languages/javascript/exercises

function helloWorld() {
    
    console.log("Hello World");
}

function twoFer(name) {

    console.log("One for " + name + ", one for me");
}

function isLeapYear(yr) {

    if (yr % 4 == 0) {
        if (yr % 100 == 0) {
            if (yr % 400 == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    return false;
}

function reverseStr(str) {

    reversed = [];
    for (let i = str.length - 1; i >= 0; i--) {
        reversed.push(str[i]);
    }
    
    return reversed;
}

function RNA(strand) {
    
    var rna_strand = [];
    
    for (let i = 0; i < strand.length; i++) {
        if (strand[i]== "G") {
            rna_strand[i] = "C";
        } else if (strand[i]== "C") {
            rna_strand[i] = "G";
        } else if (strand[i]== "T") {
            rna_strand[i] = "A";
        } else if (strand[i]== "A") {
            rna_strand[i] = "U";
        }
    }
   
    return rna_strand;
}

function isPangram(str) {

    var chs = [];
    
    for (let i = 0; i < 26; i++) {
        chs[i] = false;
    }
    for (let j = 0; j < str.length; j++) {
        chs[str[j].toLowerCase().charCodeAt() - 97] = true;
    }
    for (let k = 0; k < chs.length; k++) {
        if (chs[k] == false) { return false; }
    }
    
    return true;
}

function bob(msg) {

    let sz = msg.length;
    if (sz == 0) {
        return "Fine, be that way!";
    }
    if (msg[sz-2] == '!' && msg[sz-1] == '?') {
        return "Calm down, I know what I'm doing!"
    }
    if (msg[sz-1] == '!') {
        return "Whoa, chill out!";
    }
    if (msg[sz-1] == '?') {
        return "Sure."
    }
    return "Whatever."
}
