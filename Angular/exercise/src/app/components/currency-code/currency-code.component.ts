import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { CurrencyService } from '../../service/currency.service';
import { CommonModule } from '@angular/common';
import { validationInfo } from '../../utility/validationInfo';
import { Validation } from '../../utility/validation';

@Component({
  selector: 'app-currency-code',
  imports: [FormsModule, CommonModule],
  templateUrl: './currency-code.component.html',
  styleUrl: './currency-code.component.css'
})
export class CurrencyCodeComponent 
{
  currencyValidationInfo : validationInfo = new validationInfo(true,"");
  nicknameValidationInfo : validationInfo = new validationInfo(true,"");
  response : String = "";
  
  constructor(private currencyService: CurrencyService) {}

  submit(currencyForm:NgForm)
  { 
    const formData = {
      currency: currencyForm.value.currency,
      nickname: currencyForm.value.nickname
    };

    this.response = "";

    //Currency Validation
    this.currencyValidationInfo = Validation.validateCurrency(formData.currency);
    if(!this.currencyValidationInfo.validationPass)
    {
      return;
    }
    //Nickname Validation
    this.nicknameValidationInfo = Validation.validateNickname(formData.nickname);
    if(!this.nicknameValidationInfo.validationPass)
    {
      return;
    }
        
    console.log("Form wysłany",formData.nickname,formData.currency);
    this.currencyService.postCurrencyData(formData).subscribe(
      {
        next: (response) => {
          this.response = response.value;
        },
        error: (err) =>
        {
          console.log("Error",err.status);
          if(err.status == 406)
          {
            this.currencyValidationInfo.setInfo(false,"Podana waluta nie istnieje");
          }
          if(err.status == 503)
          {
            this.currencyValidationInfo.setInfo(false,"Serwer nie odpowiada");
          }
        }
      }
    );
  }
}
