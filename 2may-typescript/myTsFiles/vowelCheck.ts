//Write a program which takes a string from user at runtime and checks, prints the number of repeating vowels in the string
import * as readline from 'readline';
let runtimeVal = readline.createInterface({

	input: process.stdin,

	output: process.stdout

});
runtimeVal.question("Enter string to count all vowels repeatition: ",

	(answer)=>	{

		let ctr_a: number = 0;

		let ctr_e: number = 0;

		let ctr_i: number = 0;

		let ctr_o: number = 0;

		let ctr_u: number = 0;

		for(let i: number=0; i<answer.length; i++)	{

			if(answer[i] == 'a' || answer[i] == 'A')	++ctr_a;

			else if(answer[i] == 'e' || answer[i] == 'E')	++ctr_e;

			else if(answer[i] == 'i' || answer[i] == 'I')	++ctr_i;

			else if(answer[i] == 'o' || answer[i] == 'O')	++ctr_o;

			else if(answer[i] == 'u' || answer[i] == 'U')	++ctr_u;

		}

		console.log(`

a occured: ${ctr_a} times.

e occured: ${ctr_e} times.

i occured: ${ctr_i} times.

o occured: ${ctr_o} times.

u occured: ${ctr_u} times.

`);

		runtimeVal.close();

	}

);