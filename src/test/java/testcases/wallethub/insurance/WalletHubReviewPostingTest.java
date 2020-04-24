package testcases.wallethub.insurance;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pages.wallethub.common.LoginWH;
import pages.wallethub.insurance.InsuranceCompanyProfilePage;
import pages.wallethub.user.UserProfilePage;
import utils.BaseTest;

public class WalletHubReviewPostingTest extends BaseTest {
	
	LoginWH loginWH;
	InsuranceCompanyProfilePage insuranceProfilePage;
	UserProfilePage userProfilePage;

	@Override
	protected void initializePageElements() {
		loginWH = new LoginWH();
		insuranceProfilePage = new InsuranceCompanyProfilePage();
		userProfilePage = new UserProfilePage();

	}
	
	@Before
	public void LoginWalletHub() throws Exception
	{
		loginWH.loginWalletHub();
	}
	
	@Test
	public void WHReviewPostingTest() throws Exception
	{
		boolean verifyReview;
		insuranceProfilePage.navigateToCompanyProfile();
		insuranceProfilePage.accessReviewsTab();
		insuranceProfilePage.hoverOverStars();
		insuranceProfilePage.selectPolicyWithFourStarRating();
		insuranceProfilePage.submitReview();
		verifyReview = insuranceProfilePage.isMyReviewShownOnUI();
		userProfilePage.navigateToUserProfile();
		Assert.assertTrue("Review posting is not a success", userProfilePage.isReviewLinkPresent() && verifyReview );
	}

}
