"use strict";
exports.__esModule = true;
//Write a program which take a key from user at runtime and then checks whether it exists in the tuple. 
//If it is found, prints it's corresponding value
var readline = require("readline");
var valFromRuntime = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
var x;
x = ["hello", 10];
valFromRuntime.question('Please enter a key: ', function (answer) {
    if (x[1] == +answer) {
        console.log("Found, value is = " + x[0]);
    }
    else {
        console.log("Key not found");
    }
    valFromRuntime.close();
});
