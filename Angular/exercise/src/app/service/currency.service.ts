import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CurrencyService 
{
  private currencyApiUrl = 'http://localhost:8080/currencies/get-current-currency-value-command';

  constructor(private http: HttpClient) {}

  //Post data to API
  postCurrencyData(data: {currency: string, nickname: string})
  {
    return this.http.post(this.currencyApiUrl,data)
  }
}
