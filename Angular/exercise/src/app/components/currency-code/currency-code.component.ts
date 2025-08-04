import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { CurrencyService } from '../../service/currency.service';

@Component({
  selector: 'app-currency-code',
  imports: [FormsModule],
  templateUrl: './currency-code.component.html',
  styleUrl: './currency-code.component.css'
})
export class CurrencyCodeComponent 
{
  constructor(private currencyService: CurrencyService) {}

  submit(currencyForm:NgForm)
  {
    const formData = {
      currency: currencyForm.value.currency,
      nickname: currencyForm.value.nickname
    };

    console.log("Form wysłany",formData.nickname,formData.currency);

    this.currencyService.postCurrencyData(formData).subscribe();
  }
}
