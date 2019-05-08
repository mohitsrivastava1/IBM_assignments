"use strict";
exports.__esModule = true;
//Write a program which takes a number from user at runtime and then prints it factorial
var readline = require("readline");
var valFromRuntime = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
valFromRuntime.question('Please enter a number: ', function (answer) {
    var num = 1;
    for (var i = 1; i <= +answer; i++) {
        num = num * i;
    }
    console.log("The factorial is = " + num);
    valFromRuntime.close();
});
