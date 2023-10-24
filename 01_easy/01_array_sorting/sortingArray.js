numeri = new Array();
numeri = [ 0, 2, 5, 8, 3, 1, 10, 89, 56, 34];
var temp = 0;
for (i=0; i<numeri.length; i++) {
    if (numeri[i-1] > numeri[i]) {
        temp = numeri[i];
        numeri[i] = numeri[i-1];
        numeri[i-1] = temp;
    }
}
for (i=0; i<numeri.length; i++) console.log(numeri[i] + " ");