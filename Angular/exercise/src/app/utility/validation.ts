import { validationInfo } from "./validationInfo";

export class Validation
{
    //Check if currency is correct
    static validateCurrency(currency: string) : validationInfo
  {
    const info: validationInfo = new validationInfo(true,"");

    if(currency == null)
    {
        info.setInfo(false,"Waluta powinna składać się z 3 znaków");
        return info;
    }
    if(currency.length != 3)
    {
      info.setInfo(false,"Waluta powinna składać się z 3 znaków");
      return info;
    }
    if(!/^[A-Z]+$/.test(currency.toUpperCase()))
    {
        info.setInfo(false,"Waluta powinna składać się z liter");
        return info;
    }
    return info;
  }
  //Check if nickname is correct
  static validateNickname(nickname: string) : validationInfo
  {
    const info: validationInfo = new validationInfo(true,"");

    if(nickname == null)
    {
        info.setInfo(false,"Nazwa użytkownika powinna się składać z co najmniej 2 znaków");
        return info;
    }
    if(nickname.length < 2)
    {
      info.setInfo(false,"Nazwa użytkownika powinna się składać z co najmniej 2 znaków");
      return info;
    }
    if(nickname.length > 50)
    {
      info.setInfo(false,"Przekroczono limit długości nazwy użytkownika");
      return info;
    }
    if (!/^\S+\s\S+$/.test(nickname)) {
      info.setInfo(false, "Imię i Nazwisko powinno być oddzielone jedną spacją");
      return info;
    }
    if(!/^[a-zA-Z\s]+$/.test(nickname))
    {
      info.setInfo(false,"Imię i Nazwisko może składać się tylko z angielskich liter");
      return info;
    }
    if(!/^[A-Z]/.test(nickname))
    {
      info.setInfo(false,"Imię powinno zaczynać się z dużej litery");
      return info;
    }
    if(!/(?<=\s)[A-Z]/.test(nickname))
    {
      info.setInfo(false,"Nazwisko powinno zaczynać się z dużej litery");
      return info;
    }
    return info;
  }
}