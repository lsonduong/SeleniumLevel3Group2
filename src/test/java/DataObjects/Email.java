package DataObjects;

import java.util.ArrayList;
import java.util.List;

import Cores.Supporter.Utilities;

public class Email {

	private String to;
	private String cc;
	private String subject;
	private String body;
	private List<String> attachments;
	private List<String> inlinePictures;
	
	public Email(String to, String cc, String subject, String body, List<String> attachments, List<String> inlinePictures) {
		this.to = to;
		this.cc = cc;
		this.subject = subject;
		this.body = body;
		this.attachments = attachments;
		this.inlinePictures = inlinePictures;
	}
	
	public Email(String to, String cc, String subject, String body, String inlinePicture) {
		this.to = to;
		this.cc = cc;
		this.subject = subject;
		this.body = body;
		List<String> inlinePictures = new ArrayList<String>();
		inlinePictures.add(inlinePicture);
		this.inlinePictures = inlinePictures;
		this.attachments = null;
	}
	
	public Email(String attachment) {
		this.to = "any.one@email.com";
		this.cc = "";
		this.subject = "AutoGeneratedEmail" + Utilities.generateString();
		this.body = "This is an auto generated email";
		List<String> attachments = new ArrayList<String>();
		attachments.add(attachment);
		this.attachments = attachments;
		this.inlinePictures = null;
	}
	
	public String getTo() {
		return to;
	}
	
	public void setTo(String to) {
		this.to = to;
	}
	
	public List<String> getInlinePictures() {
		return inlinePictures;
	}
	
	public void setTo(List<String> inlinePictures) {
		this.inlinePictures = inlinePictures;
	}
	
	public String getCc() {
		return cc;
	}
	
	public void setCc(String cc) {
		this.cc = cc;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public List<String> getAttachments() {
		return attachments;
	}
	
	public void setAttachments(List<String> attachments) {
		this.attachments = attachments;
	}
}