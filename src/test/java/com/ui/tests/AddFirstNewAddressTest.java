package com.ui.tests;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.Address;
import com.utility.FakeAddressUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddFirstNewAddressTest extends TestBase{

    private MyAccountPage myAccountPage;
    private Address address;

    @BeforeMethod(description = "Valid First Time user logs into the application")
    public void setup(){
        myAccountPage = homePage.goToLoginPage().doLoginWith("repano2553@hopesx.com", "password");
        address = FakeAddressUtility.getFakeAddress();
    }

    @Test
    public void addNewAddress() {
        String newAddress = myAccountPage.goToAddressPage().saveAddress(address);
        Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());
    }

}
