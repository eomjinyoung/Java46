package java46.vo;

public class Project {
	String 		title;
	int				state;
	Member			manager;
	
	public Project(String title, int state) {
		this.title = title;
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Member getManager() {
		return manager;
	}

	public void setManager(Member manager) {
		this.manager = manager;
	}
	
	
}
