package member.service;

import java.util.Map;

public class JoinRequest {

	private String CLIENT_ID;
	private String CLIENT_NAME;
	private String CLIENT_SSN;
	private String CLIENT_CTN;
	private String CLIENT_MAIL;
	private String CLIENT_PWD;
	private String confirmPassword;
	
	
	public String getCLIENT_ID() {
		return CLIENT_ID;
	}

	public void setCLIENT_ID(String CLIENT_ID) {
		this.CLIENT_ID = CLIENT_ID;
	}

	public String getCLIENT_NAME() {
		return CLIENT_NAME;
	}

	public void setCLIENT_NAME(String CLIENT_NAME) {
		this.CLIENT_NAME = CLIENT_NAME;
	}

	public String getCLIENT_SSN() {
		return CLIENT_SSN;
	}

	public void setPassword(String CLIENT_SSN) {
		this.CLIENT_SSN = CLIENT_SSN;
	}

	public String getCLIENT_CTN() {
		return CLIENT_CTN;
	}

	public void setCLIENT_CTN(String CLIENT_CTN) {
		this.CLIENT_CTN = CLIENT_CTN;
	}
	
	public String getCLIENT_MAIL() {
		return CLIENT_MAIL;
	}

	public void setCLIENT_MAIL(String CLIENT_MAIL) {
		this.CLIENT_MAIL = CLIENT_MAIL;
	}
	
	public String getCLIENT_PWD() {
		return CLIENT_PWD;
	}

	public void setCLIENT_PWD(String CLIENT_PWD) {
		this.CLIENT_PWD = CLIENT_PWD;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isPasswordEqualToConfirm() {
		return CLIENT_PWD != null && CLIENT_PWD.equals(confirmPassword);
	}

	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, CLIENT_ID, "CLIENT_ID");
		checkEmpty(errors, CLIENT_NAME, "CLIENT_NAME");
		checkEmpty(errors, CLIENT_SSN, "CLIENT_SSN");
		checkEmpty(errors, CLIENT_CTN, "CLIENT_CTN");
		checkEmpty(errors, CLIENT_MAIL, "CLIENT_MAIL");
		checkEmpty(errors, CLIENT_PWD, "CLIENT_PWD");
		checkEmpty(errors, confirmPassword, "confirmPassword");
		if (!errors.containsKey("confirmPassword")) {
			if (!isPasswordEqualToConfirm()) {
				errors.put("notMatch", Boolean.TRUE);
			}
		}
	}

	private void checkEmpty(Map<String, Boolean> errors, 
			String value, String fieldName) {
		if (value == null || value.isEmpty())
			errors.put(fieldName, Boolean.TRUE);
	}
}
