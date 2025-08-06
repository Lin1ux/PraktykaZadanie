import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { validationInfo } from '../../utility/validationInfo';
import { CurrencyService } from '../../service/currency.service';
import { Validation } from '../../utility/validation';
import { NicknameResponse } from '../../models/CurrencyRequest';

@Component({
  selector: 'app-currency-request',
  imports: [FormsModule,CommonModule],
  templateUrl: './currency-request.component.html',
  styleUrl: './currency-request.component.css'
})
export class CurrencyRequestComponent 
{
  nicknameValidationInfo : validationInfo = new validationInfo(true,"");
  response: NicknameResponse[] = [];

  constructor(private currencyService: CurrencyService) {}

  submit(requestForm: NgForm)
  {
    //Formating data
    const formData = {
      nickname: requestForm.value.nickname
    };

    //Get data of all requests if input field is empty
    if(!formData.nickname)
    {
      this.currencyService.getAllData().subscribe({
        next: (response: NicknameResponse[]) => {
          this.response = response; 
          console.log('Otrzymane dane:', response);
          this.nicknameValidationInfo.setInfo(true,"");
        },
        error: (err) => {
          console.error('Błąd pobierania danych:', err);
          if(err.status == 503)
          {
            this.nicknameValidationInfo.setInfo(false,"Serwer nie odpowiada");
          }
        }
      });

      return;
    }

    //Validation
    
    this.nicknameValidationInfo = Validation.validateNickname(formData.nickname);
    if(!this.nicknameValidationInfo.validationPass)
    {
      return;
    }

    //POST data of required user's request
    this.currencyService.postNicknameData(formData).subscribe(
      {
        next: (response: NicknameResponse[]) => {
          console.log("Sukces");
          this.response = response || [];
          console.log(this.response);
        },
        error: (err) =>
        {
          console.log("Error",err.status);
        }
      }
    );
  }
}
