package member.model;

import java.util.Date;

public class Member {

	private String CLIENT_ID;
	private String CLIENT_NAME;
	private String CLIENT_SSN;
	private String CLIENT_CTN;
	private String CLIENT_MAIL;
	private String CLIENT_PWD;
	private Date regDate;

	public Member(String CLIENT_ID, String CLIENT_NAME, String CLIENT_SSN, String CLIENT_CTN, String CLIENT_MAIL, String CLIENT_PWD, Date regDate) {
		this.CLIENT_ID = CLIENT_ID;
		this.CLIENT_NAME = CLIENT_NAME;
		this.CLIENT_SSN = CLIENT_SSN;
		this.CLIENT_CTN = CLIENT_CTN;
		this.CLIENT_MAIL = CLIENT_MAIL;
		this.CLIENT_PWD = CLIENT_PWD;
		this.regDate = regDate;
	}

	public String getCLIENT_ID() {
		return CLIENT_ID;
	}

	public String getCLIENT_NAME() {
		return CLIENT_NAME;
	}

	public String getCLIENT_SSN() {
		return CLIENT_SSN;
	}
	
	public String getCLIENT_CTN() {
		return CLIENT_CTN;
	}
	
	public String getCLIENT_MAIL() {
		return CLIENT_MAIL;
	}
	
	public String getCLIENT_PWD() {
		return CLIENT_PWD;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	
	public boolean matchCLIENT_PWD(String PWD) {
		return CLIENT_PWD.equals(PWD);
	}

	public void changeCLIENT_PWD(String newPWD) {
		this.CLIENT_PWD = newPWD;
	}

}
