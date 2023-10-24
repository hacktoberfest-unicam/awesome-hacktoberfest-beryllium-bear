
int catena [128];
int index = 0;
int actualHash;


int AddBlock(char stringa []){
    if(! index)
        actualHash = HashCode("start");
    if(stringa[0] != 'X')
        return 0;
    actualHash = actualHash + HashCode(stringa);
    catena[index] = actualHash;
    index++;
    return 1;
}

int HashCode(char stringa []){
    int numero = 7;
    int i;
    for(i = 0; i < sizeof(stringa); i++){
        numero = numero * 13 + stringa[i];
    }
    return numero;
}
