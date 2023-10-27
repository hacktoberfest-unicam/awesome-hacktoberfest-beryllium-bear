import fs from "fs";

export const pathIs = (type: "Dir" | "File") => (path: string) => {
    const file = fs.lstatSync(path)
    switch (type) {
        case "Dir":
            return file.isDirectory()
        case "File":
            return file.isFile()
    }
}

export async function getData(filePath: string): Promise<string> {
    if (!fs.existsSync(filePath)) {
        throw new Error("File non esistente")
    }

    return await fs.promises.readFile(filePath, 'utf8');
}