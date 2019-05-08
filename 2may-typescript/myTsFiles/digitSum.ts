// Write a program in typescript which prints the sum of individual digits of a number entered at runtime
import * as readline from 'readline';
let valFromRuntime = readline.createInterface({
    input: process.stdin,
    output: process.stdout
  });
  
  valFromRuntime.question('Please enter a number: ', (answer) => {
      var sum=0,rem=0,num=0;
      num=+answer;
    while (num!=0) {
        rem=num%10;
        sum=sum+rem;
        num=Math.floor(num/10);
    }
    console.log("Sum = "+sum);
    valFromRuntime.close();
});