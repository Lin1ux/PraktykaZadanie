import { Component } from '@angular/core';
import { CurrencyCodeComponent } from './components/currency-code/currency-code.component';
import { CurrencyRequestComponent } from './components/currency-request/currency-request.component';

@Component({
  selector: 'app-root',
  imports: [CurrencyCodeComponent,CurrencyRequestComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'exercise';
}
