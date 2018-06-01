import { Option } from './option.model';

export class Question {
    question: string;
    options: Option[];

    constructor() {
        this.question = 'What is...';
        this.options = [];
    }
}
