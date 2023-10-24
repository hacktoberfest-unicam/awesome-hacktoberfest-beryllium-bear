public static void main(String[] args) {
    int[] arr = {64, 34, 25, 12, 22, 11};
    int[] sortedArr = arraySorting.selectionSort(arr);

    System.out.println("Sorted array:");
    for (int value : sortedArr) {
        System.out.print(value + " ");
    }
}

public static int[] selectionSort(int[] array) {
  // Creo una copia dell'array in input per non toccare l'originale
  int[] sortedArray = array.clone();
  int n = sortedArray.length;
  for (int i = 0; i < n - 1; i++) {
    // Inizializzo l'indice del minimo elemento come i
    int minIndex = i;
    for (int j = i + 1; j < n; j++) {
      // Se trovo un elemento minore del minimo attuale, aggiorno l'indice del minimo
      if (sortedArray[j] < sortedArray[minIndex]) {
        minIndex = j;
      }
    }
    // Se l'indice del minimo è diverso da i, scambio i due elementi
    if (minIndex != i) {
      int temp = sortedArray[i];
      sortedArray[i] = sortedArray[minIndex];
      sortedArray[minIndex] = temp;
    }
  }
  return sortedArray;
}