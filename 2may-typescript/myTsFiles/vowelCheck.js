"use strict";
exports.__esModule = true;
//Write a program which takes a string from user at runtime and checks, prints the number of repeating vowels in the string
var readline = require("readline");
var runtimeVal = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
runtimeVal.question("Enter string to count all vowels repeatition: ", function (answer) {
    var ctr_a = 0;
    var ctr_e = 0;
    var ctr_i = 0;
    var ctr_o = 0;
    var ctr_u = 0;
    for (var i = 0; i < answer.length; i++) {
        if (answer[i] == 'a' || answer[i] == 'A')
            ++ctr_a;
        else if (answer[i] == 'e' || answer[i] == 'E')
            ++ctr_e;
        else if (answer[i] == 'i' || answer[i] == 'I')
            ++ctr_i;
        else if (answer[i] == 'o' || answer[i] == 'O')
            ++ctr_o;
        else if (answer[i] == 'u' || answer[i] == 'U')
            ++ctr_u;
    }
    console.log("\n\na occured: " + ctr_a + " times.\n\ne occured: " + ctr_e + " times.\n\ni occured: " + ctr_i + " times.\n\no occured: " + ctr_o + " times.\n\nu occured: " + ctr_u + " times.\n\n");
    runtimeVal.close();
});
