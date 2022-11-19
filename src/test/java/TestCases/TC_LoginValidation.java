package TestCases;

import BaseClass.DriverInstance;
import Pages.AddToCartPage;
import Pages.LandingPage;
import Pages.LoginPage;
import Utilities.ExcelUtility;
import Utilities.Utils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_LoginValidation extends DriverInstance {
    @Test(dataProvider = "loginDetails")
    public void loginValidations(String username, String password)
    {
        LandingPage landing=new LandingPage(driver);
        LoginPage log=new LoginPage(driver);
        landing.clickSignIn();
        log.login(username,password);
       // Utils.verifyTextContains("https://petstore.octoperf.com/actions/Catalog.action",log.getPageUrl());
        Assert.assertTrue(Utils.verifyTextContains("https://petstore.octoperf.com/actions/Catalog.action",log.getPageUrl()));
        AddToCartPage addtocart=new AddToCartPage(driver);
        addtocart.orderPlaced();
    }
    @DataProvider(name="loginDetails")
    public  Object[][] userDetails()
    {
        ExcelUtility.setExcelfile("src/test/Resources/Testdata/testfile1.xlsx","DataSheet");
        Object[][] test= ExcelUtility.getTableData("TC_LoginValidation");
       // Object[][] test=new Object[][]{{"pooja21","pooja21"},{"admin","admin"}};
        return test;//*[@id="Content"]/ul/li/text()
    }



}
