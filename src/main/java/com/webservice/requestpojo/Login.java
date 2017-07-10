package com.webservice.requestpojo;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*has getter and setter*/
public class Login {

	@SerializedName("loginId")
	@Expose
	private String loginId;
	@SerializedName("password")
	@Expose
	private String password;
	@SerializedName("LoginSource")
	@Expose
	private String loginSource;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginSource() {
		return loginSource;
	}

	public void setLoginSource(String loginSource) {
		this.loginSource = loginSource;
	}

}
