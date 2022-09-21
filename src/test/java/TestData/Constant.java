package TestData;

import Cores.Supporter.Utilities;
import DataObjects.Account;
import DataObjects.Email;

public class Constant {

	public static final int TIMEOUT = 30;
	public static final int WebTimeOut = 600;
	public static final String ConfigFile = "\\ConfigFiles\\config.cfg";
	public static final String HUB_URL = "http://192.168.172.147:4444/wd/hub";
	
	//chrome
	public static final String ChromeDriverKey = "Chrome";
	public static final String ChromeDriverRemoteKey = "ChromeRemote";
	public static final String ChromeDriverPath = "\\Executables\\chromedriver.exe";
	
	//firefox
	public static final String FirefoxDriverKey = "FF";
	public static final String FirefoxDriverRemoteKey = "FFRemote";
	public static final String FirefoxDriverPath = "\\Executables\\geckodriver.exe";
	
	
	//Logigear Email Data
	public static final String LgMailUrl = "https://sgmail.logigear.com";
	public static final Account TestAccount = new Account("duong.luong","p@ssw0rd2");
	public static final Email TestEmail = new Email(Utilities.getProjectPath() + "\\ConfigFiles\\config.cfg");
	public static final String ImageDownload = Utilities.getProjectPath() + "\\ConfigFiles\\saved.jpg";
	public static final Email TestEmailImage = new Email("duong.luong@logigear.com",""
			,"AutoEmailWithImage" + Utilities.generateString(),"This is an auto test email"
			,Utilities.getProjectPath() + "\\ConfigFiles\\lamont2.jpg");
	public static final String LgMailAttachment = "config.cfg";
	public static final String LgMailPicture = "BAAAAAAA";
	public static final String DismissAllXapth = "//a[@id='divBtnDismissall']";
	
	//Agoda
	public static final String AgodaDatePattern = "EEE MMM dd yyyy";
	public static final String AgodaUrl = "https://www.agoda.com/";
	public static final String[] PopInfoList = new String[] {"Cleanliness", "Facilities", "Service", "Location", "Value for money"};
	
	//Vietjet
	public static final String VietjetUSUrl = "https://www.vietjetair.com/Sites/Web/en-US/Home";
	public static final String VietjetVNUrl = "https://www.vietjetair.com/Sites/Web/vi-VN/Home";
	public static final String VietjetDatePattern = "MMM d yyyy";
	public static final String VietjetBPattern = "dd/MM/yyyy";
}
