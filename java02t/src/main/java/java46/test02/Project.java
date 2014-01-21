package java46.test02;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

@Named("ohoraProject")
@Scope("singleton")
public class Project {
	String 		title;
	int				state;
	Member			manager;
	Set<Member> members;
	
	public Project() {}
	
	public Project(String title, int state) {
		this.title = title;
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	@Inject
	public void setTitle(@Value("프로젝트테스트") String title) {
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

	//@Autowired
	//@Qualifier("mgr3")
	@Inject
	public void setManager(@Named("mgr3") Member manager) {
		this.manager = manager;
	}

	public Set<Member> getMembers() {
		return members;
	}

	public void setMembers(Set<Member> members) {
		this.members = members;
	}
	
	
}
