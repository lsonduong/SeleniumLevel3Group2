package TestModules.LogigearEmail_TestSuite;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Actions.LogigearEmailActions;
import Cores.Reporting.ExtentTestManager;
import TestData.Constant;
import TestModules.TestBase;

@Listeners(Cores.Reporting.TestListener.class)	

public class MailBoxTests extends TestBase {
	
	@Test
	public void MailBoxTestsTC_01() {
		
		LogigearEmailActions actions = new LogigearEmailActions(); 
		
		ExtentTestManager.logInfo("TC_01 - Compose and save draft email successfully.");
			
		ExtentTestManager.logInfo("Step1 Navigate to https://sgmail.logigear.com/");
		actions.openLgMail();
			
		ExtentTestManager.logInfo("Step2 Log in with your account");
		actions.login(Constant.TestAccount);
			
		ExtentTestManager.logInfo("Step3 Compose new email with attachment");
		ExtentTestManager.logInfo("Step4 Save the email and close the composing email pop up");	
		actions.composeNewMailAndSave(Constant.TestEmail);	
		
		ExtentTestManager.logInfo("The email is save to Draft folder successfully with correct info(receiver, subject, attachment, content)");
		actions.checkMailInDrafts(Constant.TestEmail, Constant.LgMailAttachment);

	}
	
	@Test
	public void MailBoxTestsTC_02() {
		
		LogigearEmailActions actions = new LogigearEmailActions(); 
		
		ExtentTestManager.logInfo("TC_01 - Compose and save draft email successfully.");
			
		ExtentTestManager.logInfo("Step1 Navigate to https://sgmail.logigear.com/");
		actions.openLgMail();
			
		ExtentTestManager.logInfo("Step2 Log in with your account");
		actions.login(Constant.TestAccount);
			
		ExtentTestManager.logInfo("Step3 Compose new email with image inserted on the content");
		ExtentTestManager.logInfo("Step4 Send the email to your email");	
		actions.composeNewMailAndSend(Constant.TestEmailImage);	
		
		ExtentTestManager.logInfo("The email is sent successfully with correct info(receiver, subject, attachment, content)");
		ExtentTestManager.logInfo("Step5 Open the new received email and download the image in this email");
		actions.checkMailInBox(Constant.TestEmailImage, Constant.LgMailPicture);
		
		ExtentTestManager.logInfo("Open the new received email and download the image in this email");
		ExtentTestManager.logInfo("Download the image successfully.");
		actions.checkDownloadImage(Constant.LgMailPicture, Constant.ImageDownload);
	}
	
}