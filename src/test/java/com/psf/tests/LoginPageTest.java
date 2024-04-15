package com.psf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.psf.pages.OrangeHRMLoginPage;

public final class LoginPageTest extends BaseTest {
	// reason to keep class as final : NO ONE CAN EXTEND IT.
	// REASON TO KEEP PRIVATE CONSTRUCTOR : not allow to create object from base
	// layers.

	private LoginPageTest() {
	}

	@Test
	public void test_valid_login() {
		try {
			boolean b = new OrangeHRMLoginPage().enterUsername("Admin").enterPassword("admin123").click_submit()
					.verify_dashboard_title_is_visible();
			Assert.assertTrue(b, "Dashboard is not visible on Homepage.");
		} catch (Exception e) {
			e.getLocalizedMessage();
		}
	}

	@Test
	public void test_valid_logout() {
		try {
			String title = new OrangeHRMLoginPage().enterUsername("Admin").enterPassword("admin123").click_submit()
					.click_userdropdown().click_logout_btn().get_title();
			Assert.assertEquals(title, "OrangeHRM", "LoginPageTest: OrangeHRM title is not visible");
		} catch (Exception e) {
			e.getLocalizedMessage();
		}

	}

	@Test
	public void test_error_message_on_invalid_username_and_password() {
		OrangeHRMLoginPage lpoh = new OrangeHRMLoginPage();
		try {
			lpoh.enterUsername("Admin").enterPassword("admin13").click_submit();
			Assert.assertTrue(lpoh.verify_error_msg(), "LoginPageTest: Error message is not displayed");
		} catch (Exception e) {
			e.getLocalizedMessage();
		}
	}

}
