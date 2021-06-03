package in.nandhini.model;

public class UserInfo {
	/**
	 * User Info Details in List
	 */
	public Long mobileNo;
	public String password;
	public String userName;
	public String gender;

	public UserInfo(long mobNo, String pwd, String name, String gender) {
		super();
		this.mobileNo = mobNo;
		this.password = pwd;
		this.userName = name;
		this.gender = gender;
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

	public String getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return "UserInfo [mobileNo=" + mobileNo + ", password=" + password + ", userName=" + userName + ", gender="
				+ gender + "]";
	}

}
