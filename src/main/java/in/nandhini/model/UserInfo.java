package in.nandhini.model;

import lombok.Data;

@Data
public class UserInfo {

	/**
	 * User Info Details in List
	 */
	private Long mobileNo;
	private String password;
	private String userName;
	private String gender;

	public UserInfo(long mobNo, String pwd, String name, String gender) {
		super();
		this.mobileNo = mobNo;
		this.password = pwd;
		this.userName = name;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "UserInfo [mobileNo=" + mobileNo + ", password=" + password + ", userName=" + userName + ", gender="
				+ gender + "]";
	}

}
