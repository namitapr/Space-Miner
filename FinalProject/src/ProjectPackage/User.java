package ProjectPackage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
	@SerializedName("username")
	@Expose
	String username;
	@SerializedName("password")
	@Expose
	String password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public void setUsername(String newUsername) {
		this.username = newUsername;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}
	
	public String getPassword() {
		return password;
	}
	
}











