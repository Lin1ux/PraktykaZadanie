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
    if(!/^[0-9a-zA-Z _]+$/.test(nickname))
    {
      info.setInfo(false,"Nazwa użytkownika może składać się z angielskich liter, cyfr, spacji i _");
      return info;
    }
    return info;
  }
}