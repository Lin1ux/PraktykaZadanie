export class ValidationInfo
{
    constructor(
        public validationPass: Boolean = false,
        public errorMessage:String = "")
    {
        this.validationPass = validationPass;
        this.errorMessage = errorMessage;
    }
}