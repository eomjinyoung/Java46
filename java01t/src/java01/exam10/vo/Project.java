package java01.exam10.vo;

import java.util.Date;

public class Project {
	public static final int READY = 0;
	public static final int WORKING = 1;
	public static final int COMPLETE = 2;
	public static final int CANCEL = 3;
	
	String 		title;
	String			description;
	Date				startDate;
	Date				endDate;
	int				state;
	Member			owner;
}
