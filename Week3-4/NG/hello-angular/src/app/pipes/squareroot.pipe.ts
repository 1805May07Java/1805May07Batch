import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sqrt' // name of pipe, will be used in html to transform data. {{ num | sqrt}}
})
export class SquarerootPipe implements PipeTransform {

  // (num | pipe: param, param )
  // function necessary to use pipe
  transform(val: number): number {
    return Math.sqrt(val);
  }

}
