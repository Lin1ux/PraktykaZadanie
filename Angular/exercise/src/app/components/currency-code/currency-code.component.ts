import { Component, OnDestroy } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { CurrencyService } from '../../services/currency.service';
import { CommonModule } from '@angular/common';
import { ValidationInfo } from '../../utilities/validationInfo';
import { Validation } from '../../utilities/validation';
import { Subject, takeUntil } from 'rxjs';
import { CurrencyValidatorDirective } from '../../validators/currency-validator.directive';
import { NicknameValidatorDirective } from '../../validators/nickname-validator.directive';

@Component({
  selector: 'app-currency-code',
  imports: [FormsModule, CommonModule,CurrencyValidatorDirective,NicknameValidatorDirective],
  templateUrl: './currency-code.component.html',
  styleUrl: './currency-code.component.css'
})
export class CurrencyCodeComponent implements OnDestroy
{
  public currencyValidationInfo : string = '';
  public nicknameValidationInfo : ValidationInfo = new ValidationInfo(true,"");
  public response : string = "";
  public showError = false;

  public destroy$ = new Subject<void>();

  formData = {
      currency: '',
      nickname: ''
    };
  
  constructor(
    private currencyService: CurrencyService,
  ) {}

  ngOnDestroy(): void 
  {
      this.destroy$.next();
      this.destroy$.complete();
  }

  submit(currencyForm:NgForm)
  { 
    this.showError = true;
    this.currencyValidationInfo = ''
    if(!currencyForm.valid)
    {
      this.showError = true;
      return;
    }

    console.log("Gut");
    this.response = "";

    console.log(this.formData);
        
    this.currencyService.postCurrencyData(this.formData)
    .pipe(
      takeUntil(this.destroy$)
    )
    .subscribe(
      {
        next: (response) => {
          this.response = response.value;
        },
        error: (err) =>
        {
          console.log("Error",err.status);
          if(err.status == 400)
          {
            this.currencyValidationInfo = "Błędne dane";
          }
          if(err.status == 406)
          {
            this.currencyValidationInfo = "Podana waluta nie istnieje"
          }
          if(err.status == 422)
          {
            this.currencyValidationInfo = "Zła składnia danych"
          }
          if(err.status == 503)
          {
            this.currencyValidationInfo = "Serwer nie odpowiada"
          }
        }
      }
    );
  }
}
