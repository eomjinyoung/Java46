package spms.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import spms.annotations.Component;
import spms.vo.Member;

@Component
public class MemberDao {
	SqlSessionFactory sqlSessionFactory;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public List<Member> selectList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectList("spms.dao.MemberDao.selectList");
	}
	
	public Member selectOne(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("spms.dao.MemberDao.selectOne", no);
	}
	
	public int insert(Member member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int count = sqlSession.insert("spms.dao.MemberDao.insert", member);
		sqlSession.commit();
		
		return count;
	}
	
	public int update(Member member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int count = sqlSession.update("spms.dao.MemberDao.update", member);
		sqlSession.commit();
		
		return count;
	}
	
	// SqlSession은 autocommit 기본 값이 false이다.
	public int delete(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int count = sqlSession.delete("spms.dao.MemberDao.delete", no);
		sqlSession.commit();
		
		return count;
	}
	
	public Member selectByEmailPassword(String email, String password) 
			throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		HashMap<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("email", email);
		paramMap.put("password", password);
		
		return sqlSession.selectOne(
				"spms.dao.MemberDao.selectByEmailPassword", paramMap);
	}
	
}







