package ProjectPackage;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Database {
	@SerializedName("users")
	@Expose
	List<User> users = null;
	
	public Database() {
		this.users = new ArrayList<User>();
	}
	
	public List<User> getDatabase() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public int indexOfUser(String username) {
		if (users != null) {
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getUsername().equals(username)) {
					return i;
				}
			}
			return -1;
		}
		else {
			return -1;
		}
	}
}
