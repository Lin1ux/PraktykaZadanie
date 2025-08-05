import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CurrencyService 
{
  private currencyApiUrl = 'http://localhost:8080/currencies/get-current-currency-value-command';
  private currencyRequestApiUrl = 'http://localhost:8080/currencies/requests';

  constructor(private http: HttpClient) {}

  //Post data to currency API
  postCurrencyData(data: {currency: string, nickname: string}): Observable<{value:string}>
  {
    return this.http.post<{value:string}>(this.currencyApiUrl,data)
  }
  getCurrencyData(currency: string, nickname: string): Observable<any>
  {
    const params = new HttpParams().set("currency",currency).set("nickname",nickname);

    return this.http.get(this.currencyRequestApiUrl, {params} )
  }

  //Post data to currency requests API
  postNicknameData(data: {nickname: string})
  {
    return this.http.post(this.currencyRequestApiUrl,data)
  }
}
