
export class Percentage {
    private x: number
    private total: number
    public readonly value: number
    constructor(x: number, total: number) {
        this.x = x
        this.total=total
        this.value = x / total
    }
    toString(fractionDigits: number = 2){
        return (this.value * 100).toFixed(fractionDigits) + "%"
    }
}