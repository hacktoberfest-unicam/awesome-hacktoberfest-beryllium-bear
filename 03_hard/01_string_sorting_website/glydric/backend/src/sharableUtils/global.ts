export function die(message: any | { message: string }) {
    if (typeof message === "object") {
        console.log(message.message)
    } else {
        console.error(message)

    }

    process.exit(1)
}

export const singleSplit = (value: string, separator: string | RegExp) => {
    const [s, ...ss] = value.split(separator)
    return [s, ss.join(" ")]
}

export function swap(arr: any[], a: any, b: any) {
    const tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
}