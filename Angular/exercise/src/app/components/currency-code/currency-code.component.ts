import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { CurrencyService } from '../../service/currency.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-currency-code',
  imports: [FormsModule, CommonModule],
  templateUrl: './currency-code.component.html',
  styleUrl: './currency-code.component.css'
})
export class CurrencyCodeComponent 
{
  currencyError : String = "";
  nicknameError : String = "";
  
  constructor(private currencyService: CurrencyService) {}

  validateCurrency(currency: string) : Boolean
  {
    if(currency.length != 3)
    {
      this.currencyError = "Waluta powinna składać się z 3 znaków";
      return false;
    }
    if(!/^[A-Z]+$/.test(currency.toUpperCase()))
    {
      this.currencyError = "Waluta powinna składać się z liter";
      return false;
    }
    return true;
  }
  validateNickname(nickname: string)
  {
    if(nickname.length < 2)
    {
      this.nicknameError = "Nazwa użytkownika powinna się składać z co najmniej 2 znaków";
      return false;
    }
    if(nickname.length > 50)
    {
      this.nicknameError = "Przekroczono limit długości nazwy użytkownika";
      return false;
    }
    if(!/^[0-9a-zA-Z _]+$/.test(nickname))
    {
      this.nicknameError = "Nazwa użytkownika może składać się z liter, cyfr, spacji i _";
      return false;
    }
    return true;
  }

  submit(currencyForm:NgForm)
  {
    this.nicknameError = "";
    this.currencyError = "";
    
    const formData = {
      currency: currencyForm.value.currency,
      nickname: currencyForm.value.nickname
    };

    
    if(!this.validateCurrency(formData.currency))
    {
      return;
    }
    if(!this.validateNickname(formData.nickname))
    {
      return;
    }
        
    console.log("Form wysłany",formData.nickname,formData.currency);
    this.currencyService.postCurrencyData(formData).subscribe(
      {
        next: (response) => {
          console.log("Sukces");
        },
        error: (err) =>
        {
          console.log("Error",err.message);
        }
      }
    );
  }
}
