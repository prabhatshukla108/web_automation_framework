package com.psf.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.psf.pages.OrangeHRMLoginPage;
import com.psf.reports.ExtentManager;
import com.psf.reports.ExtentReport;
//import com.psf.reports.ExtentReport;

public final class LoginPageTest extends BaseTest {
	// reason to keep class as final : NO ONE CAN EXTEND IT.
	// REASON TO KEEP PRIVATE CONSTRUCTOR : not allow to create object from base
	// layers.

	private LoginPageTest() {
	}

	@Test(dataProvider = "LoginData")
	public void test_valid_login(String username, String password) {
		try {
			boolean b = new OrangeHRMLoginPage().enterUsername(username).enterPassword(password).click_submit()
					.verify_dashboard_title_is_visible();
			Assert.assertTrue(b, "Dashboard is not visible on Homepage.");
		} catch (Exception e) {
			e.getLocalizedMessage();
		}
	}

	@DataProvider(name = "LoginData", parallel=true)
	public Object[][] getData() {
		return new Object[][] { { "Admin", "admin123" }

		};
	}

	@Test
	public void test_valid_logout() {
		try {
			String title = new OrangeHRMLoginPage().enterUsername("Admin").enterPassword("admin123").click_submit()
					.click_userdropdown().click_logout_btn().get_title();
			Assert.assertEquals(title, "OrangHRM", "LoginPageTest: OrangeHRM title is not visible");
		} catch (Exception e) {
	        // Other exceptions occurred, fail the test and print the exception message
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }

	}

	@Test
	public void test_error_message_on_invalid_username_and_password() {
		   OrangeHRMLoginPage lpoh = new OrangeHRMLoginPage();
		    try {
		        lpoh.enterUsername("Admin").enterPassword("admin13").click_submit();
		        Assert.assertTrue(lpoh.verify_error_msg(), "LoginPageTest: Error message is not displayed");
		    }catch (Exception e) {
		        // Other exceptions occurred, fail the test and print the exception message
		        Assert.fail("Exception occurred: " + e.getMessage());
		    }
		}

}
