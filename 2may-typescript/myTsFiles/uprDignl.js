//Write a program which prints the upper diagonal of a matrices array
var arr = [[65, 33, 10], [9, 2, 1015], [6, 31, 45]];
for (var i = 0; i < 3; i++) {
    for (var j = 0; j < 3 - i; j++) {
        console.log(arr[i][j]);
    }
    console.log("\n");
}
