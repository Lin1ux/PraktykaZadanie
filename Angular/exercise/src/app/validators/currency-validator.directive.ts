import { Directive } from '@angular/core';
import { AbstractControl,NG_VALIDATORS, Validator } from '@angular/forms';

@Directive({
  selector: '[appCurrencyValidator]',
  standalone: true, 
  providers: [
    {
      provide: NG_VALIDATORS,
      useExisting: CurrencyValidatorDirective,
      multi: true
    }
  ]
})
export class CurrencyValidatorDirective implements Validator{

  constructor() { }

  validate(control: AbstractControl): { [key: string]: any } | null 
  {
    if (!control.value) return null;

    const value = control.value.toUpperCase();

    if(value.length != 3)
    {
      return { customCurrencyError: 'Waluta powinna składać się z 3 znaków' };
    }
    if(!/^[A-Z]+$/.test(value.toUpperCase()))
    {
      return { customCurrencyError: 'Waluta powinna składać się z liter' };
    }
    return null
  }

}
