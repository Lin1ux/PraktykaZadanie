export class validationInfo
{
    public validationPass: Boolean = false;
    public errorMessage: String = "";

    public constructor(validationPass?: Boolean,errorMessage?:String)
    {
        this.setInfo(validationPass || false,errorMessage || "");
    }

    public setInfo(validationPass: Boolean,errorMessage:String)
    {
        this.validationPass = validationPass;
        this.errorMessage = errorMessage;
    }

}