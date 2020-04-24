package testcases.facebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pages.facebook.common.LoginFB;
import pages.facebook.posts.PostPage;
import utils.BaseTest;

public class FaceBookStatusPostingTest extends BaseTest {

	
	LoginFB loginFB;
	PostPage postPage;
	
	@Override
	protected void initializePageElements() {
		loginFB = new LoginFB();
	}
	
	@Before
	public void LoginFaceBook() throws Exception
	{
		loginFB.loginFaceBook();
	}
	
	@Test
	public void FBStatusPostingTest() throws Exception
	{
		postPage.createFBPost();
		Assert.assertTrue("Status posting is not a success", postPage.isPostSuccessful());
	}

}
