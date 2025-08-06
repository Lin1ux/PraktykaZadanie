export class validationInfo
{
    public validationPass: Boolean = false;
    public errorMessage: String = "";

    public constructor(validationPass?: Boolean,errorMessage?:String)
    {
        this.setInfo(validationPass || false,errorMessage || "");
    }

    //Setter
    public setInfo(validationPass: Boolean,errorMessage:String)
    {
        this.validationPass = validationPass;
        this.errorMessage = errorMessage;
    }

}