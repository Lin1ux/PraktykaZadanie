import { ValidationInfo } from "./validationInfo";

export class Validation
{
    //Check if currency is correct
    static validateCurrency(currency: string) : ValidationInfo
  {
    //info: ValidationInfo = new ValidationInfo(true,"");

    if(currency == null)
    {
      return new ValidationInfo(false,"Waluta powinna składać się z 3 znaków");
    }
    if(currency.length != 3)
    {
      
      return new ValidationInfo(false,"Waluta powinna składać się z 3 znaków");
    }
    if(!/^[A-Z]+$/.test(currency.toUpperCase()))
    {
        return new ValidationInfo(false,"Waluta powinna składać się z liter");
    }
    return new ValidationInfo(true,"");
  }
  //Check if nickname is correct
  static validateNickname(nickname: string) : ValidationInfo
  {
    if(nickname == null)
    {
        return new ValidationInfo(false,"Nazwa użytkownika powinna się składać z co najmniej 2 znaków");
    }
    if(nickname.length < 2)
    {
      return new ValidationInfo(false,"Nazwa użytkownika powinna się składać z co najmniej 2 znaków");
    }
    if(nickname.length > 50)
    {
      return new ValidationInfo(false,"Przekroczono limit długości nazwy użytkownika");
    }
    if (!/^\S+\s\S+$/.test(nickname)) {
      return new ValidationInfo(false, "Imię i Nazwisko powinno być oddzielone jedną spacją");
    }
    if(!/^[a-zA-Z\s]+$/.test(nickname))
    {
      return new ValidationInfo(false,"Imię i Nazwisko może składać się tylko z angielskich liter");
    }
    if(!/^[A-Z]/.test(nickname))
    {
      return new ValidationInfo(false,"Imię powinno zaczynać się z dużej litery");
    }
    if(!/(?<=\s)[A-Z]/.test(nickname))
    {
      return new ValidationInfo(false,"Nazwisko powinno zaczynać się z dużej litery");
    }
    return new ValidationInfo(true,"");
  }
}