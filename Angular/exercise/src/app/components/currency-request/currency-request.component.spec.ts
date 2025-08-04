import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CurrencyRequestComponent } from './currency-request.component';

describe('CurrencyRequestComponent', () => {
  let component: CurrencyRequestComponent;
  let fixture: ComponentFixture<CurrencyRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CurrencyRequestComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CurrencyRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
