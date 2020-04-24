package utils;

public class ApplicationConfiguration {
	
	public static final String fb_applicationURL = DefaultConfiguration.getProperty("fb.application");
	public static final String fb_username = DefaultConfiguration.getProperty("fb.username");
	public static final String fb_password = DefaultConfiguration.getProperty("fb.password");
	
	public static final String fb_message = DefaultConfiguration.getProperty("fb.message");
	
	public static final String wh_applicationURL = DefaultConfiguration.getProperty("wh.application");
	public static final String wh_username = DefaultConfiguration.getProperty("wh.username");
	public static final String wh_password = DefaultConfiguration.getProperty("wh.password");
	
	public static final String wh_insurance_profileURL = DefaultConfiguration.getProperty("wh.insurance.profile");
	public static final String wh_user_profileURL = DefaultConfiguration.getProperty("wh.user.profile");
	
	public static String getFBApplicationURL(){
		return fb_applicationURL;
	}
	
	public static String getFBUsername(){
		return fb_username;
	}
	
	public static String getFBUserPassword(){
		return fb_password;
	}
	
	public static String getFBStatusMessage(){
		return fb_message;
	}
	
	public static String getWHApplicationURL(){
		return wh_applicationURL;
	}
	
	public static String getWHUsername(){
		return wh_username;
	}
	
	public static String getWHUserPassword(){
		return wh_password;
	}
	
	public static String getWHInsuranceCompanyProfileURL(){
		return wh_insurance_profileURL;
	}
	
	public static String getWHUserProfileURL(){
		return wh_user_profileURL;
	}

}
