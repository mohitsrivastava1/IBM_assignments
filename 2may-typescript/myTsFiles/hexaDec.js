"use strict";
exports.__esModule = true;
//Write a program which prints the hex-decimal equivalent of a decimal number entered at runtime
var readline = require("readline");
var runtimeVal = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
runtimeVal.question("Enter a number to find it's hexadecimal value: ", function (answer) {
    var num = parseInt(answer);
    var hexVal = "";
    while (num != 0) {
        switch (num % 16) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                hexVal += num % 16;
                break;
            case 10:
                hexVal += "A";
                break;
            case 11:
                hexVal += "B";
                break;
            case 12:
                hexVal += "C";
                break;
            case 13:
                hexVal += "D";
                break;
            case 14:
                hexVal += "E";
                break;
            case 15:
                hexVal += "F";
                break;
        }
        num = Math.floor(num / 16);
    }
    hexVal += "x0";
    var hexValRev = "";
    for (var i = hexVal.length - 1; i >= 0; --i) {
        hexValRev += hexVal[i];
    }
    console.log("Hexadecimal Value is: " + hexValRev);
    runtimeVal.close();
});
