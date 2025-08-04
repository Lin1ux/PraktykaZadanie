import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CurrencyCodeComponent } from './currency-code.component';

describe('CurrencyCodeComponent', () => {
  let component: CurrencyCodeComponent;
  let fixture: ComponentFixture<CurrencyCodeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CurrencyCodeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CurrencyCodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
