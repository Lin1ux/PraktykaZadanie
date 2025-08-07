import { Directive } from '@angular/core';
import { AbstractControl, NG_VALIDATORS, Validator } from '@angular/forms';

@Directive({
  selector: '[appNicknameValidator]',
  standalone: true, 
  providers: [
    {
      provide: NG_VALIDATORS,
      useExisting: NicknameValidatorDirective,
      multi: true
    }
  ]
})

export class NicknameValidatorDirective implements Validator
{

  constructor() { }

  validate(control: AbstractControl): { [key: string]: any } | null 
  {
    const value = control.value;
    
    if (!value)
    {
      return null;
    } 
    
    if (value.length < 2) 
    {
      return { customNicknameError: 'Nazwa użytkownika powinna się składać z co najmniej 2 znaków' };
    }
    
    if(value.length > 50)
    {
      return { customNicknameError: 'Przekroczono limit długości nazwy użytkownika' };
    }

    if(!/^\S+\s\S+$/.test(value))
    {
      return { customNicknameError: 'Imię i Nazwisko powinno być oddzielone jedną spacją' };
    }

    if (!/^[a-zA-Z\s]+$/.test(value)) 
      {
      return { customNicknameError: 'Imię i Nazwisko może składać się tylko z angielskich liter' };
    }

    if (!/^[A-Z]/.test(value)) 
      {
      return { customNicknameError: 'Imię powinno zaczynać się z dużej litery' };
    }

    if (!/(?<=\s)[A-Z]/.test(value)) 
      {
      return { customNicknameError: 'Nazwisko powinno zaczynać się z dużej litery' };
    }
    
    return null;
  }
}
