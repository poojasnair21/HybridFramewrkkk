package Utilities;

public class Utils {
    public static boolean verifyTextContains(String actualText, String expText) {
        if (actualText.toLowerCase().contains(expText.toLowerCase())){
            System.out.println("Actual Text From Web Application UI   --> : "+ actualText);
            System.out.println("Expected Text From Web Application UI --> : "+ expText);
            System.out.println("### Verification Contains !!!");
            return true;
        }
        else{
            System.out.println("Actual Text From Web Application UI   --> : "+ actualText);
            System.out.println("Expected Text From Web Application UI --> : "+ expText);
            System.out.println("### Verification DOES NOT Contains !!!");
            return false;
        }

    /*public static boolean verifyTextContains(String actuaText,String expText)
    {
        if(actuaText.toLowerCase().contains(expText.toLowerCase()))
        {
        System.out.println("Actual text from webapplicationUI:"+actuaText);
        System.out.println("Expected text from webapplicationUI:"+expText);
        System.out.println("Verification contains");
        return true;}
    else
    {
        System.out.println("Actual text from webapplicationUI:"+actuaText);
        System.out.println("Expected text from webapplicationUI:"+expText);
        System.out.println("Verification do not contains");
        return false;
    }*/
}}
