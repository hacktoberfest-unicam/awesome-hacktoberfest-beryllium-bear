import {swap} from "./sharableUtils/global";

export default class Sort {
    values: number[]

    constructor(values: number[]) {
        this.values = values;
    }

    sort = (method: string): number[] => getInstance(method)(this.values);
}

type SortMethod = (values: number[]) => number[]
const getInstance = (type: string): SortMethod => {
    switch (type.toLowerCase()) {
        case "quick":
        case "quicksort":
            return Sorts.quickSort
        case "bubble":
        case "bubblesort":
            return Sorts.bubbleSort
        case "merge":
        case "mergesort":
            return Sorts.mergeSort
        case "heap":
        case "heapsort":
            return Sorts.heapSort
        case "selection":
        case "selectionsort":
            return Sorts.selectionSort
    }
}

abstract class Sorts {
    static quickSort: SortMethod = (arr: number[]): number[] => {
        if (arr.length <= 1) {
            return arr;
        }

        const pivot: number = arr[0];
        const left: number[] = [];
        const right: number[] = [];

        for (let i: number = 1; i < arr.length; i++) {
            if (arr[i] < pivot) {
                left.push(arr[i]);
            } else {
                right.push(arr[i]);
            }
        }

        return [...Sorts.quickSort(left), pivot, ...Sorts.quickSort(right)]
    }
    static bubbleSort: SortMethod = (arr: number[]): number[] => {
        const size = arr.length;

        for (let i = 0; i < size - 1; i++) {
            for (let j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }
    static mergeSort: SortMethod = (arr: number[]): number[] => {
        if (arr.length <= 1) {
            return arr;
        }

        const middle = Math.floor(arr.length / 2);
        const left = arr.slice(0, middle);
        const right = arr.slice(middle);

        return mergeS(Sorts.mergeSort(left), Sorts.mergeSort(right));
    }
    static heapSort: SortMethod = (arr: number[]): number[] => {
        buildMaxHeap(arr);

        for (let end = arr.length - 1; end > 0; end--) {
            // Scambia l'elemento massimo (radice) con l'elemento "end" dell'heap
            [arr[0], arr[end]] = [arr[end], arr[0]];

            // Ripristina l'heap max sul resto dell'array (escludendo l'elemento massimo)
            heapify(arr, 0, end);
        }

        return arr;
    }
    static selectionSort: SortMethod = (arr: number[]): number[] => {
        for (let i = 0; i < arr.length - 1; i++) {
            let min = i;

            for (let j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // Choose the lesser of the two:
                    min = j;
                }
            }
            // In-place swap:
            const tmp = arr[min];
            arr[min] = arr[i];
            arr[i] = tmp;
        }
        return arr
    }

}

function buildMaxHeap(arr: number[]): void {
    const n = arr.length;
    for (let i = Math.floor(n / 2); i >= 0; i--) {
        heapify(arr, i, n);
    }
}

function heapify(arr: number[], i: number, heapSize: number): void {
    const left = 2 * i + 1;
    const right = 2 * i + 2;
    let largest = i;

    if (left < heapSize && arr[left] > arr[largest]) {
        largest = left;
    }

    if (right < heapSize && arr[right] > arr[largest]) {
        largest = right;
    }

    if (largest !== i) {
        [arr[i], arr[largest]] = [arr[largest], arr[i]];
        heapify(arr, largest, heapSize);
    }
}

function mergeS(left: number[], right: number[]): number[] {
    let result: number[] = [];
    let leftIndex = 0;
    let rightIndex = 0;

    while (leftIndex < left.length && rightIndex < right.length) {
        if (left[leftIndex] < right[rightIndex]) {
            result.push(left[leftIndex]);
            leftIndex++;
        } else {
            result.push(right[rightIndex]);
            rightIndex++;
        }
    }

    return result.concat(left.slice(leftIndex), right.slice(rightIndex));
}
