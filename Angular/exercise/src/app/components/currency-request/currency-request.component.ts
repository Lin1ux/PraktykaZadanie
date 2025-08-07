import { CommonModule } from '@angular/common';
import { Component, OnDestroy } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { ValidationInfo } from '../../utilities/validationInfo';
import { CurrencyService } from '../../services/currency.service';
import { Validation } from '../../utilities/validation';
import { NicknameResponse } from '../../models/currency-request';
import { Subject, take, takeUntil } from 'rxjs';
import { NicknameValidatorDirective } from '../../validators/nickname-validator.directive';

@Component({
  selector: 'app-currency-request',
  imports: [FormsModule,CommonModule,NicknameValidatorDirective],
  templateUrl: './currency-request.component.html',
  styleUrl: './currency-request.component.css'
})
export class CurrencyRequestComponent implements OnDestroy
{
  
  public response: NicknameResponse[] = [];
  public nicknameValidationInfo : ValidationInfo = new ValidationInfo(true,"");
  public destroy$ = new Subject<void>();
  public showError = false;

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

  submit(requestForm: NgForm)
  {
    this.showError = false;
    if(!this.formData.nickname)
    {
      this.currencyService.getAllData()
      .pipe(
        takeUntil(this.destroy$)
      )
      .subscribe({
        next: (response: NicknameResponse[]) => {
          this.response = response; 
          console.log('Otrzymane dane:', response);
          this.nicknameValidationInfo = new ValidationInfo(true,"");
        },
        error: (err) => {
          console.error('Błąd pobierania danych:', err);
          if(err.status == 503)
          {
            this.nicknameValidationInfo = new ValidationInfo(false,"Serwer nie odpowiada");
          }
        }
      });

      return;
    }

    if(!requestForm.valid)
    {
      this.showError = true;
      return;
    }


    /*this.nicknameValidationInfo = Validation.validateNickname(formData.nickname);
    if(!this.nicknameValidationInfo.validationPass)
    {
      return;
    }*/

    this.currencyService.postNicknameData(this.formData)
    .pipe(
      takeUntil(this.destroy$)
    )
    .subscribe(
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
