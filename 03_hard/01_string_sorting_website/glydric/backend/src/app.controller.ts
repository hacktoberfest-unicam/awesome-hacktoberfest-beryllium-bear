import {Body, Controller, Get, Post} from '@nestjs/common';
import Sort from "./sorts";

type Body = {
    values: number[];
    type: string;
}

@Controller()
export class AppController {
    @Post()
    backend(@Body() body: Body): string {
        const s = new Sort(body.values);
        console.log(`get ~ ${body.values} ~ ${body.type}`)
        try {
            console.log(`[${s.sort(body.type)}]`)
            return `[${s.sort(body.type)}]`;
        } catch (e) {
            return "Error: unknown type"
        }
    }
}
