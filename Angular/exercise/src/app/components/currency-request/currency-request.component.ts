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
    const formData = {
      nickname: requestForm.value.nickname
    };

    this.nicknameValidationInfo = Validation.validateNickname(formData.nickname);
    if(!this.nicknameValidationInfo.validationPass)
    {
       return;
    }

    console.log("Nazwa Użytkownika wysłana",formData.nickname);
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
