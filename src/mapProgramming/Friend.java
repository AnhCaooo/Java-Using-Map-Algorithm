package mapProgramming;

public class Friend {

	
	
	private String nickName;
	private String name; 
	private String birthday; 
	
	public Friend(String nickName, String name, String birthday) {
		this.nickName = nickName; 
		this.name = name;
		this.birthday = birthday; 
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return this.nickName + ": " + this.name + ", born " + this.birthday; 
	}
}
