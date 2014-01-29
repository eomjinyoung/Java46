package spms.dao;

import java.util.ArrayList;
import java.util.List;

import spms.vo.Task;

public interface TaskDao {
	public ArrayList<Task> selectList() throws Exception;
	public Task selectOne(int no) throws Exception;
	public int insert(Task task) throws Exception;	
	public int update(Task task) throws Exception;
	public int delete(int no) throws Exception;
	public List<Task> selectMyTasks(int no) throws Exception;
}







