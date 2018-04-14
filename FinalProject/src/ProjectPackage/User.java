package ProjectPackage;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Serializable {
	@SerializedName("username")
	@Expose
	String username;
	@SerializedName("password")
	@Expose
	String password;
	@SerializedName("stats")
	@Expose
	Statistics stats;
	
	private final static long serialVersionUID = -5659000743766857262L;
	
	public User(String username, String password, Statistics stats) {
		this.username = username;
		this.password = password;
		this.stats = stats;
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
	
	public void setStats(Statistics stats) {
		this.stats = stats;
	}
	
	public Statistics getStats() {
		return stats;
	}
	
}











