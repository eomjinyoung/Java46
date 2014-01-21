package java46.test03;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

@Named("ohoraProject")
public class Project {
	String 		title;
	int				state;
	
	@Inject
	Member			manager;
	Set<Member> members;
	

	
}
