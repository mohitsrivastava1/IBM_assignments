//Write a program which takes a number from user at runtime and then prints it factorial
import * as readline from 'readline';
let valFromRuntime = readline.createInterface({
    input: process.stdin,
    output: process.stdout
  });
  
  valFromRuntime.question('Please enter a number: ', (answer) => {
      var num=1;
      for(var i=1;i<=+answer;i++)
      {
          num=num*i;
      }
      console.log("The factorial is = "+num);
      valFromRuntime.close();
    });