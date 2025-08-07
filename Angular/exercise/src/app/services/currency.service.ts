import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { NicknameResponse } from '../models/currency-request';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class CurrencyService 
{
  /*private currencyApiUrl = 'http://localhost:8080/currencies/get-current-currency-value-command';
  private currencyRequestApiUrl = 'http://localhost:8080/currencies/request';
  private AllRequestApiUrl = 'http://localhost:8080/currencies/requests';*/

  constructor(private http: HttpClient) {}

  //Post data to currency API
  postCurrencyData(data: {currency: string, nickname: string}): Observable<{value:string}>
  {
    return this.http.post<{value:string}>(environment.currencyApiUrl,data);
  }
  
  //Post data to currency requests API
  postNicknameData(data: {nickname: string}): Observable<NicknameResponse[]>
  {
    return this.http.post<NicknameResponse[]>(environment.currencyRequestApiUrl,data);
  }

  //Get data to currency requests API
  getAllData(): Observable<NicknameResponse[]>
  {
    return this.http.get<NicknameResponse[]>(environment.AllRequestApiUrl);
  }
}
