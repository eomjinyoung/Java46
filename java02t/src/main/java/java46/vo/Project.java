package java46.vo;

import java.util.Set;

public class Project {
	String 		title;
	int				state;
	Member			manager;
	Set<Member> members;
	
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

	public Set<Member> getMembers() {
		return members;
	}

	public void setMembers(Set<Member> members) {
		this.members = members;
	}
	
	
}
