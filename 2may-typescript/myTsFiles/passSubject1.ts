//Write a program in JS which takes marks of 3 subjects from user at runtime and then prints 
//whether a student is passing(only once) depending upon whether s/he's passing in every subject, 
//otherwise the output should be failing(only once). (Build logic without using logical operators, 
//nested if's - Just use the plain if blocks)
import * as readline from 'readline';
let runtimeVal = readline.createInterface({

	input: process.stdin,

	output: process.stdout

});
function passOrNot(num1?: number, num2?: number, num3?: number)	{

	let result: boolean = true;

	let totalSum: number = num1 + num2 + num3;

	if(totalSum < 125)	{

		result = false;

	}

	if (num1 < 40)	{

		result = false;

	}

	if (num2 < 40)	{

		result = false;

	}

	if (num3 < 40)	{

		result = false;

	}



	//Test for result

	if(result == false)	{

		console.log("Failed!");

	}

	else	{

		console.log("Passed!");

	}

}



runtimeVal.question("Enter all 3 numbers with spaces: ",

	(answer)=>	{

		let sub = answer.split(" ");

		let sub_1 = parseInt(sub[0]);

		let sub_2 = parseInt(sub[1]);

		let sub_3 = parseInt(sub[2]);



		passOrNot(sub_1, sub_2, sub_3);

		runtimeVal.close();

	}

);