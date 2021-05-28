package in.nandhini.service;

public class UserInfo {
	private Long mobileNo;
	private String password;
	private String userName;

	public UserInfo(long mobNo, String pwd, String name) {
		super();
		this.mobileNo = mobNo;
		this.userName = name;
		this.password = pwd;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public String getName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
}
